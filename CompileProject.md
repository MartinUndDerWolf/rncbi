# Checkout #
To check out the project see the [source section](https://code.google.com/p/rncbi/source/checkout) of the project.


# Preparation #
To compile the source files of the java part, it is necessary to get some libraries and include them into the build path.
This is simply done by downloading them and copying to the right destination.
  1. First download the Axis2 libraries from [Apache Axis2](http://ws.apache.org/axis2/) site.
  1. The **Standard Binary Distribution** is sufficient for our needs. Save it somewhere and extract it.
  1. Inside the just created Axis2 directory exists a **lib** directory. The content of this directory needs to be copied to the _R-Source/inst/java_ directory of the svn checkout. See the [Optimization](CompileProject#Optimization.md) for some optimization.
  1. After that we also need the JUnit library from [JUnit Home](http://www.junit.org/).
  1. Save the JUnit jar file in the _junit-libs_ directory.
  1. Be sure to have the **EFetch** jar files contained in the EFetch directory.


# Compilation #
For each version of the RNCBI package a separate directory inside the "trunk" directory exists.
Each directory contains a _build.xml_ and a _javadoc.xml_.
The _build.xml_ is a ant task file, which can be run by calling ant inside the directory of the build file.<br>
Or call ant with the build file as argument<br>
<pre><code>ant -buildfile build.xml<br>
</code></pre>
This creates an <i>RInterface.jar</i> file, which is necessary for the R package.<br>
<br>
In addition to the normal compilation, a junit test can be invoked by calling the target "withjunit" of the build file<br>
<pre><code>ant -buildfile build.xml withjunit<br>
</code></pre>
But be careful, as this might take a while.<br />After the junit test has been completed successfully a report can be found in the <i>build_RInterface</i> directory.<br>
<br>
The last step is to copy the created jar files (NCBIStub.jar and RInterface.jar) and all jars from the EFetch directory into the <i>R-Source/inst/java</i> directory.<br>
<br>
<h1>Create the R Package</h1>
To create the R package the development tools are required. On unix systems these tools are included in the standard R installation, for other operating systems see your preferred web search engine.<br>
The directory structure of the svn checkout is already the one we need to create an R package. So we simply do:<br>
<pre><code>R CMD check R-Source/<br>
R CMD build R-Source/<br>
</code></pre>
The last step creates a tar.gz file which contains the package.<br>
This file can be installed with the<br>
<pre><code>R CMD INSTALL RNCBI_x.y.tar.gz<br>
</code></pre>
command.<br>
<p>

<h1>Optimization</h1>
As not all libraries from the Apache Axis2 framework are required to communicate with the webservice, <br>we can remove some of them from the <i>R-Source/inst/java</i> directory.<br>
<ul><li>activation-1.1.jar<br>
</li><li>axiom-dom-1.2.8.jar<br>
</li><li>axis2-adb-codegen-1.5.1.jar<br>
</li><li>axis2-ant-plugin-1.5.1.jar<br>
</li><li>axis2-clustering-1.5.1.jar<br>
</li><li>axis2-codegen-1.5.1.jar<br>
</li><li>axis2-corba-1.5.1.jar<br>
</li><li>axis2-fastinfoset-1.5.1.jar<br>
</li><li>axis2-java2wsdl-1.5.1.jar<br>
</li><li>axis2-jaxbri-1.5.1.jar<br>
</li><li>axis2-jaxws-1.5.1.jar<br>
</li><li>axis2-jibx-1.5.1.jar<br>
</li><li>axis2-json-1.5.1.jar<br>
</li><li>axis2-metadata-1.5.1.jar<br>
</li><li>axis2-mtompolicy-1.5.1.jar<br>
</li><li>axis2-saaj-1.5.1.jar<br>
</li><li>axis2-spring-1.5.1.jar<br>
</li><li>axis2-xmlbeans-1.5.1.jar<br>
</li><li>bcel-5.1.jar<br>
</li><li>commons-fileupload-1.2.jar<br>
</li><li>geronimo-<code>*</code>.jar<br>
</li><li>jalopy-1.5rc3.jar<br>
</li><li>jaxb-<code>*</code>.jar<br>
</li><li>jaxen-1.1.1.jar<br>
</li><li>jettison-1.0.RC2.jar<br>
</li><li>jibx-<code>*</code>.jar<br>
</li><li>mex-1.5.1.jar<br>
</li><li>smack<code>*</code>.jar<br>
</li><li>soapmonitor-1.5.1.jar<br>
</li><li>woden-api-1.0M8.jar<br>
</li><li>woden-impl-dom-1.0M8.jar<br>
</li><li>wstxl-asl-3.2.4.jar<br>
</li><li>xalan-2.7.0.jar<br>
</li><li>xercesImpl-2.6.2.jar</li></ul>

<code>*</code> means every character possible.