package de.hzi.infg;

//import gov.nih.nlm.ncbi.www.soap.eutils.EFetchPmcServiceStub;
//import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchRequestDocument;
//import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pmc.EFetchResultDocument;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchRequest;
import gov.nih.nlm.ncbi.www.soap.eutils.efetch_pubmed.EFetchResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.io.FileUtils;

import de.hzi.infg.interfaces.TypeInterface;
import de.hzi.infg.test.InvocationTest;

/**
 * This is a class with manual tests. The JUnit tests are located in
 * {@link InvocationTest}.
 * 
 * @author Martin Schumann
 * 
 */
@SuppressWarnings("all")
public class TestInvocation {

	// this is for only for testing
	public static void main(String[] args) {
		Map<String, String> ma = new HashMap<String, String>();
		ma.put("db", "");
		ma.put("tool", "");
		ma.put("email", "");

		// RInterface ri = new RInterface("http://18.8.80.1:4321", false, true);
		// ri.setProxyUser("master", "");
		RInterface ri = new RInterface("", false, true);
		String[] einfo = { "db", "genome", "tool", "", "email", "" };
		String[] egquery = { "term", "mouse", "tool", "", "email", "" };
		String[] esearch = { "db", "gene", "term", "mouse", "webenv", "", "query_key", "", "usehistory", "", "tool", "", "email", "", "field", "",
				"reldate", "", "mindate", "", "maxdate", "", "datetype", "", "retstart", "", "retmax", "5", "rettype", "", "sort", "" };
		// To list all available links in PubMed, except for libraries, for PMIDs
		// 12085856 and 12085853:
//		String[] elink = { "db", "", "id", "12085856" + RInterface.BREAKWORD + "12085853", "reldate", "", "mindate", "", "maxdate", "", "datetype", "",
//				"term", "", "dbfrom", "pubmed", "webenv", "", "query_key", "", "cmd", "llinks", "tool", "", "email", "", "linkname", "" };
		// To retrieve IDs from CoreNucleotide for GI 48819, 7140345 to Protein:
		String[] elink = { "db", "protein", "id", "48819" + RInterface.BREAKWORD + "7140345", "reldate", "", "mindate", "", "maxdate", "", "datetype",
				"", "term", "", "dbfrom", "nuccore", "webenv", "", "query_key", "", "cmd", "", "tool", "", "email", "", "linkname", "" };
		// To create history (WebEnv & query_key) for Protein GI 50806715,
		// 50810195 neighbors from Nucleotide and Taxonomy:
		// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/elink.fcgi?id=50806715&id=1698399&cmd=neighbor_history&dbFrom=protein&db=nuccore,taxonomy
		// String[] elink = {"db", "nuccore,taxonomy", "id",
		// "1698399"+RInterface.BREAKWORD+"50806715", "reldate", "", "mindate",
		// "", "maxdate", "", "datetype", "",
		// "term", "", "dbfrom", "protein", "webenv", "", "query_key", "", "cmd",
		// "neighbor_history", "tool", "", "email", "", "linkname", ""};
		String[] esummary = { "db", "nucleotide", "id", "28864546" + RInterface.BREAKWORD + "28800981", "webenv", "", "query_key", "", "retstart", "",
				"retmax", "", "tool", "", "email", "" };
		String[] espell = { "db", "pubmed", "term", "asthmaa+OR+hay+fevar", "tool", "", "email", "" };
		String[] epost = { "db", "pubmed", "id", "37281", "webenv", "", "tool", "", "email", "" };
		String[] efetch_pubmed = { "id", "12091962" + RInterface.BREAKWORD + "9997", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype",
				"", "retmax", "", "query_key", "" };
		// get a list of ids from the esearch:
		// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=nlmcatalog&term=MacDonald&retmax=700
		String[] efetch_nlmc = { "id", "1408329", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype", "", "retmax", "", "query_key", "" };
		// example Arabidopsis thaliana id 3702, if the id was not found, an
		// AxisFault is thrown "Unexpected subelement TaxaSet"
		String[] efetch_taxon = { "id", "3702", "webenv", "", "email", "", "query_key", "", "tool", "", "report", "" };
		String[] efetch_omim = { "id", "179605", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype", "", "retmax", "", "query_key", "" };
		// found id with esearch, looking for "mouse"
		String[] efetch_journals = { "id", "20318", "retstart", "", "webenv", "", "email", "", "querykey", "", "tool", "", "rettype", "", "retmax", "" };
		// example id: 52657273, 52592489
		String[] efetch_snp = { "id", "52657273" + RInterface.BREAKWORD + "52592489", "retstart", "", "webenv", "", "email", "", "query_key", "",
				"tool", "", "retmax", "" };
		String[] efetch_sequence = { "db", "nuccore", "webenv", "", "complexity", "", "tool", "", "strand", "", "seq_stop", "", "rettype", "", "id",
				"294612694", "retstart", "", "seq_start", "", "query_key", "", "email", "", "report", "", "retmax", "" };
		// example:
		// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pmc&id=212403
		String[] efetch_pmc = { "id", "212403", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype", "", "retmax", "", "querykey", "" };
		String[] efetch_gene = { "id", "214271", "retstart", "", "webenv", "", "email", "", "tool", "", "retmax", "", "querykey", "" };
		// ri.EInfoInterface(einfo);
		// String[] resultPar = ri.getDbNames();
		// System.out.println(ri.isDbInfo());
		// for (String string : resultPar) {
		// System.out.print(string+" ");
		// }
		// String[] tmpAr = ri.getComplexType("fieldlist");
		// for (String string : tmpAr) {
		// System.out.println(string);
		// }
		// ri.EGQueryInterface(egquery);
		// String[] tmpAr = ri.getComplexType("resultitem");
		// for (String string : tmpAr) {
		// System.out.println(string);
		// }
		// ri.ESearchInterface(esearch);
		// ri.ESummaryInterface(esummary);
		 ri.ELinkInterface(elink);
		// ri.ESpellInterface(espell);
		// ri.EPostInterface(epost);
		// the call to the efetch starts with the init and db as argument
//		ri.initEFetchOperation("journals");
		// after that the service can be called
//		ri.EFetchInterface(efetch_journals);
		// pmc: pmcarticleset
		// journals: serialsset
		// String[] res = ri.getComplexType("serialsset");
		// System.out.println("res: "+Arrays.toString(res));
		System.out.println("Error caused: " + ri.isErrorCaused());
		// String[] tmp = ri.getRequestParameter("efetch");
		// for (String string : tmp) {
		// System.out.print("\""+string+"\", \"\", ");
		// }
		// System.out.println();
		// String[] resultPar = ri.getResultParameter();
		// for (String string : resultPar) {
		// System.out.print("\""+string+"\", ");
		// }
		// System.out.println();
		String[] tmpPara = ri.getResultParameter();
		for (int i = 0; i < tmpPara.length; i += 2) {
			// System.out.println(tmpPara[i]+": "+tmpPara[i+1]);
			if (tmpPara[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex
				String[] comp = ri.getComplexType(tmpPara[i]);
				for (String res : comp) {
					 File file = new File("ExampleOut/eUtilsExampleELinkNCBIRes.xml");
					 try {
					 FileUtils.writeStringToFile(file, res);
					 } catch (IOException e) {
					 e.printStackTrace();
					 }
//					System.out.println(res);
				}
			} else {
				System.out.println("Simple " + ri.getSimpleType(tmpPara[i]));
			}
		}

		// Map<String, Object> efetchMap = ri.getResultMap();
		// for (String key : efetchMap.keySet()) {
		// System.out.println(key+":\n"+efetchMap.get(key));
		// }
		// // eSearch getResultMap test:
		// Map<String, Object> esearchResultMap = ri.getResultMap();
		// for (String key : esearchResultMap.keySet()) {
		// Object tmpValue = esearchResultMap.get(key);
		// if (tmpValue == null) {
		// // an empty value
		// continue;
		// }
		// if
		// (tmpValue.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE))
		// {
		// Map<String, Object> secondMap = ((TypeInterface)
		// tmpValue).getParametersMap();
		// for (String secondKey : secondMap.keySet()) {
		// Object secondTmpValue = secondMap.get(secondKey);
		// System.out.println(secondTmpValue.getClass());
		// // there are arrays at a deep of 2, either string arrays or ncbi
		// package arrays
		// Object[] objAr = (Object[]) secondTmpValue;
		// if
		// (objAr[0].getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE))
		// {
		// // this is an array of classes from the ncbi package
		// for (Object object : objAr) {
		// Map<String, Object> thirdMap = ((TypeInterface)
		// object).getParametersMap();
		// for (String thirdKey : thirdMap.keySet()) {
		// System.out.println(object.getClass()+" "+thirdKey+" "+thirdMap.get(thirdKey));
		// Object fourthObj = thirdMap.get(thirdKey);
		// if (!(fourthObj instanceof String) && fourthObj != null) {
		// // must be TermSet, be careful because TermSetType can be null
		// System.out.println(((TypeInterface) fourthObj).getParametersMap());
		// }
		// }
		// }
		// } else if (objAr[0] instanceof String){
		// // else it is an array of strings
		// String[] stringAr = (String[]) secondTmpValue;
		// for (String string : stringAr) {
		// System.out.println(string);
		// }
		// }
		// }
		// System.out.println();
		// }
		// }
		// ri.ELinkInterface(elink);
		// ri.storeResult("eSearchResult");
		// String[] paras = ri.getResultParameter();
		// Map<String, Object> resMap = ri.getResultMap();
		// String key = "linkset";
		// Object[] rootObj = (Object[]) resMap.get(key);
		// String[] res = ri.getComplexType(key);
		// System.out.println(rootObj);
		// for (String string : res) {
		// System.out.println("Res: "+string);
		// }

		// for (int i = 0; i < paras.length; i+=2) {
		// if (paras[i+1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
		// System.out.println("Complex: "+paras[i]);
		// System.out.println("GetComplexType:");
		// String[] tmpCompl = ri.getComplexType(paras[i]);
		// for (String string : tmpCompl) {
		// System.out.println("ComplexString:"+string);
		// // look at the array of objects{
		// String[] tmpResults = string.split("\\{bw\\}");
		// // String[] results = new String[tmpResults.length-1];
		// // String subSets = tmpResults[0];
		// // System.arraycopy(tmpResults, 1, results, 0, tmpResults.length-1);
		// // String[] subSetResults = subSets.split("\\{ss\\}");
		// // System.out.println(subSetResults.length+" "+results.length);
		// // if (subSetResults.length == results.length) {
		// // int reverseOrder = subSetResults.length;
		// // for (int j = 0; j < subSetResults.length; j++) {
		// // reverseOrder--;
		// // System.out.println(subSetResults[reverseOrder]+" "+results[j]);
		// // }
		// // } else
		// for (String res : tmpResults) {
		// System.out.println("Res: "+res);
		// }
		// }
		// } else {
		// System.out.println("Simple: "+paras[i]+" "+ri.getSimpleType(paras[i]));
		// }
		// }

		// System.out.println(ri.getResultParameterByName("idlist"));
		// Map<String, Object> tmpResultMap = ri.getResultMap();
		// for (String key : tmpResultMap.keySet()) {
		// Object obj = tmpResultMap.get(key);
		// if (obj != null) {
		// System.out.println(key+" "+obj.getClass().getName()+" "+obj.getClass().isArray());
		// } else
		// System.out.println(key+" "+obj);
		// }
		// String[] tmpCompl = ri.getComplexType("idlist");
		// for (String string : tmpCompl) {
		// // look at the array of objects{
		// System.out.println(string);
		// }
		// String[] res = ri.getResultParameter();
		// for (String string : res) {
		// // look at the array of objects{
		// System.out.println(string);
		// }

		// ri.getResultParameterByName("hans");
		// System.out.println(ri.getRequestParameter("einfo"));
		// System.out.println(ri.getSimpleType("dbname"));
		// String[] tmp = ri.getResultParameters();
		// for (String string : tmp) {
		// System.out.println(string);
		// }
		// String tmp = ri.getComplFromStoredResult(true);
		// System.out.println(tmp);

		// // xmlbeans test:
		// EFetchPmcServiceStub pmcService = null;
		// try {
		// pmcService = new EFetchPmcServiceStub();
		// } catch (AxisFault e) {
		// e.printStackTrace();
		// }
		// Options options = pmcService._getServiceClient().getOptions();
		// options.setProperty(HTTPConstants.CHUNKED, Constants.VALUE_FALSE);
		// EFetchRequestDocument req =
		// EFetchRequestDocument.Factory.newInstance();
		//
		// // example:
		// //
		// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pmc&id=212403
		// req.addNewEFetchRequest().setId("212403");
		// EFetchResultDocument res = null;
		// try {
		// res = pmcService.run_eFetch(req);
		// } catch (RemoteException e) {
		// e.printStackTrace();
		// }
		// System.out.println(res.getEFetchResult().getPmcArticleset().getArticleArray()[0].getFront().getArticleMeta().getTitleGroup().getArticleTitle());
		// // res.getEFetchResult().getPmcArticleset().getArticleArray()[0].get
		// Method[] methods =
		// res.getEFetchResult().getPmcArticleset().getArticleArray()[0].getClass().getDeclaredMethods();
		// int count = 0;
		// for (Method method : methods) {
		// if (method.getName().startsWith("get")) {
		// count++;
		// String type = method.getReturnType().getName();
		// if (type.toString().startsWith(RInterface.XMLBEANS_PACKAGE)) {
		// System.out.println(method.getName()+" type: "+type);
		// }
		// }
		// }
		// System.out.println(count);

		// File file = new File("eFetchPMCExample.xml");
		// try {
		// FileUtils.writeStringToFile(file,
		// res.getEFetchResult().getPmcArticleset().toString());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	private static void getInformation(Object firstObj, String key, Stack<String> stack, int deep) {
		// Map<String, Object> secondMap = ((TypeInterface)
		// firstObj).getParametersMap();
		String prefix = "";
		for (int i = 0; i < deep; i++) {
			prefix += i + "\t";
		}
		if (firstObj.getClass().getPackage().getName().startsWith(RInterface.NCBI_PACKAGE)) {
			System.out.println(prefix + "NCBI object: " + firstObj.getClass().getName());
			Map<String, Object> firstMap = ((TypeInterface) firstObj).getParametersMap();
			for (String secKey : firstMap.keySet()) {
				getInformation(firstMap.get(secKey), secKey, stack, deep + 1);
			}
		} else if (firstObj.getClass().isArray()) {
			System.out.println(prefix + "Array of: " + firstObj.getClass().getName() + " length: " + ((Object[]) firstObj).length);
			for (Object thirdObj : (Object[]) firstObj) {
				getInformation(thirdObj, key, stack, deep + 1);
			}
		} else if (firstObj == null) {
			System.out.println(prefix + key + " = empty");
		} else if (firstObj instanceof String) {
			System.out.println(prefix + "String: " + key + " " + firstObj);
		}
	}

}
