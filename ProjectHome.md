# RNCBI Package #
This package provides access to the NCBI Webservice inside R.
The user provides the request parameter and starts a request, which returns a result provided as list in R.

Feedback is always welcome!

## News ##
  * The package is now included in the [CRAN](http://cran.r-project.org/).
  * eInfo is working again
  * Nlmc isn't working right now, due to changes in the soap messages. Will fix this soon.

## Requirements ##
  * rJava See http://www.rforge.net/rJava/ for information
  * XML See http://cran.r-project.org/web/packages/XML/index.html for more information.
  * The Axis2 libs are **not** necessary, as all required libs come with the package. License information and libs are located inside inst/java directory.

## Installation ##
  * Download the source package from the downloads section.<br>
<ul><li><b><code>R CMD INSTALL RNCBI_0.9.tar.gz</code></b> will install the package<br>
</li><li>Or simply type <b><code>install.packages("RNCBI")</code></b> inside your R environment.</li></ul>

<h2>Notes (0.9)</h2>
<ul><li>This version is an alpha release. Please report everything to me or use the discussion/issue tracker.</li></ul>

<h2>Examples</h2>
The vignette (RNCBIManual.pdf) inside the package or from the download section contains examples for each web service operation.<br>
<br>
<h3>TODO</h3>
<ul><li>Upload split packages and modify Wiki accordingly<br>
</li><li>Upload implementation details (is anybody interested in this?)<br>
</li><li>Take a look into pubchem and the possibilities to use it with R.