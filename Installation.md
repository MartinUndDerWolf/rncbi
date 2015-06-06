# Introduction #
With this package it is possible to access data from the NCBI Webservice inside R and use this data for further processing.
The package provides the returned data in the form of a list object. This list can be inspected further, see the [Examples](Examples.md) for more details.

# Installation #
Installation of the package is quite easy as it doesn't need to compile anything.
The only precondition is to provide [Java 5](http://www.java.com/) or higher.<br>
To successfully install the RNCBI package the following packages are necessary.<br>
<h2>rJava</h2>
To install this package, simply type<br>
<pre><code>install.packages("rJava")<br>
</code></pre>
into the R console. Further informations on this package can be found at the <a href='http://www.rforge.net/rJava/'>rJava site</a>.<br>
<blockquote><font color='red'>If you are on a unix system, make sure R was configured with Java support.</font></blockquote>
To do this without re-installing R do<br>
<pre><code>R CMD javareconf<br>
</code></pre>
on the command line, maybe root privileges are required to do this.<br>
<h2>XML</h2>
This also can be installed with the package system from R, simply type<br>
<pre><code>install.packages("XML")<br>
</code></pre>
Further informations can be found on this <a href='http://cran.r-project.org/web/packages/XML/index.html'>site</a>.<br>
<br>
<h2>RNCBI</h2>
The package itself can be installed from <a href='http://cran.r-project.org/'>CRAN</a> directly.<br>
To do this inside R type:<br>
<pre><code>install.packages("RNCBI")<br>
</code></pre>