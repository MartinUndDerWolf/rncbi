package de.hzi.infg.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hzi.infg.RInterface;

/**
 * This class provides some JUnit tests for all the operations. They only test
 * if the service is available with some example parameters.
 * 
 * @author Martin Schumann
 * 
 */
public class InvocationTest {

	private RInterface ri;

	@Before
	public void setUp() throws Exception {
		// first thing to do, create a RInterface object
		ri = new RInterface("", true, true);
	}

	@After
	public void tearDown() throws Exception {
		// nothing to do
	}

	@Test
	public void test_eInfoDbNames() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("einfo");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "tool", "email" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// now some requests, first one without any parameter
		String[] einfoReq1 = { "db", "", "tool", "", "email", "" };
		ri.EInfoInterface(einfoReq1);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		// this should be no dbInfo
		assertFalse(ri.isDbInfo());
		// a list of database names should be returned
		assertNotNull(ri.getDbNames());
	}

	@Test
	public void test_eInfoDbInfo() {
		// next case, a dbInfo for "genome" database
		String[] einfoReq2 = { "db", "genome", "tool", "", "email", "" };
		ri.EInfoInterface(einfoReq2);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		// this should be a dbInfo
		assertTrue(ri.isDbInfo());
		String[] expectedResultParameter = { "lastupdate", "false", "fieldlist", "true", "description", "false", "dbname", "false", "linklist", "true",
				"menuname", "false" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleEInfoResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eGQuery() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("egquery");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "term", "tool", "email" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] egqueryReq = { "term", "mouse", "tool", "", "email", "" };
		ri.EGQueryInterface(egqueryReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] expectedResultParameter = { "term", "false", "resultitem", "true" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleEGQueryResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eSearch() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("esearch");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "term", "webenv", "query_key", "usehistory", "tool", "email", "field", "reldate", "mindate", "maxdate",
				"datetype", "retstart", "retmax", "rettype", "sort" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] esearchReq = { "db", "journals", "term", "stem", "webenv", "", "query_key", "", "usehistory", "", "tool", "", "email", "", "field",
				"", "reldate", "", "mindate", "", "maxdate", "", "datetype", "", "retstart", "", "retmax", "15", "rettype", "", "sort", "" };
		ri.ESearchInterface(esearchReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] expectedResultParameter = { "webenv", "false", "querykey", "false", "retstart", "false", "retmax", "false", "count", "false",
				"idlist", "true", "translationset", "true", "translationstack", "true", "querytranslation", "false", "errorlist", "true", "warninglist",
				"true" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleESearchResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eSummary() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("esummary");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "id", "webenv", "query_key", "retstart", "retmax", "tool", "email" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] esummaryReq = { "db", "nucleotide", "id", "28864546" + RInterface.BREAKWORD + "28800981", "webenv", "", "query_key", "", "retstart",
				"", "retmax", "", "tool", "", "email", "" };
		ri.ESummaryInterface(esummaryReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] expectedResultParameter = { "docsum", "true" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleESummaryResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eLink() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("elink");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "id", "reldate", "mindate", "maxdate", "datetype", "term", "dbfrom", "webenv", "query_key", "cmd",
				"tool", "email", "linkname" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] elinkReq = { "db", "", "id", "12085856" + RInterface.BREAKWORD + "12085853", "reldate", "", "mindate", "", "maxdate", "", "datetype",
				"", "term", "", "dbfrom", "pubmed", "webenv", "", "query_key", "", "cmd", "llinks", "tool", "", "email", "", "linkname", "" };
		ri.ELinkInterface(elinkReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] expectedResultParameter = { "linkset", "true" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleELinkResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eSpell() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("espell");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "term", "tool", "email" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eSpellReq = { "db", "pubmed", "term", "asthmaa hay fevar", "tool", "", "email", "" };
		ri.ESpellInterface(eSpellReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] expectedResultParameter = { "query", "false", "database", "false", "correctedquery", "false", "spelledquery", "true" };
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			// System.out.println(actualResultParameter[i] + ": " +
			// actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleESpellResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_ePost() {
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("epost");
		assertNotNull(actualReqParameter);
		String[] expectedReqParameter = { "db", "id", "webenv", "tool", "email" };
		assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] ePostReq = { "db", "pubmed", "id", "37281", "webenv", "", "tool", "", "email", "" };
		ri.EPostInterface(ePostReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "webenv", "false",
		// "invalididlist", "true", "querykey", "false" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eUtilsExampleEPostResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_EfetchRequest() {
		// only test, if the array is still present
		assertNotNull(RInterface.getEFetchDatabases());
	}

	@Test
	public void test_eEfetchPubmed() {
		// prepare efetch operation
		ri.initEFetchOperation("pubmed");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "id", "retstart", "webenv", "email",
		// "tool", "rettype", "retmax", "query_key" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchPubmedReq = { "id", "12091962" + RInterface.BREAKWORD + "9997", "retstart", "", "webenv", "", "email", "", "tool", "",
				"rettype", "", "retmax", "", "query_key", "" };
		ri.EFetchInterface(eFetchPubmedReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "pubmedarticleset", "true",
		// "idlist", "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExamplePubmedResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchNlmc() {
		// prepare efetch operation
		ri.initEFetchOperation("nlmc");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "id", "retstart", "webenv", "email",
		// "tool", "rettype", "retmax", "query_key" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchNlmcReq = { "id", "1408329", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype", "", "retmax", "", "query_key", "" };
		ri.EFetchInterface(eFetchNlmcReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "nlmcatalogrecordset", "true",
		// "idlist", "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleNlmcResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchTaxon() {
		// prepare efetch operation
		ri.initEFetchOperation("taxon");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "id", "webenv", "email", "query_key",
		// "tool", "report" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchTaxonReq = { "id", "3702", "webenv", "", "email", "", "query_key", "", "tool", "", "report", "" };
		ri.EFetchInterface(eFetchTaxonReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "taxaset", "true", "idlist",
		// "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleTaxonResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchOmim() {
		// prepare efetch operation
		ri.initEFetchOperation("omim");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "id", "retstart", "webenv", "email",
		// "tool", "rettype", "retmax", "query_key" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchOmimReq = { "id", "179605", "retstart", "", "webenv", "", "email", "", "tool", "", "rettype", "", "retmax", "", "query_key", "" };
		ri.EFetchInterface(eFetchOmimReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "mimentries", "true", "idlist",
		// "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleOmimResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchSnp() {
		// prepare efetch operation
		ri.initEFetchOperation("snp");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "id", "retstart", "webenv", "email",
		// "query_key", "tool", "retmax" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchSnpReq = { "id", "52657273" + RInterface.BREAKWORD + "52592489", "retstart", "", "webenv", "", "email", "", "query_key", "",
				"tool", "", "retmax", "" };
		ri.EFetchInterface(eFetchSnpReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "exchangeset", "true", "idlist",
		// "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleSnpResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchSequence() {
		// prepare efetch operation
		ri.initEFetchOperation("sequence");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// String[] expectedReqParameter = { "db", "webenv", "complexity", "tool",
		// "strand", "seq_stop", "rettype", "id", "retstart", "seq_start",
		// "query_key", "email", "report", "retmax" };
		// // comparison not possible, because the order differs
		// assertArrayEquals(expectedReqParameter, actualReqParameter);
		// next fire a request
		String[] eFetchSequenceReq = { "db", "nuccore", "webenv", "", "complexity", "", "tool", "", "strand", "", "seq_stop", "", "rettype", "", "id",
				"294612694", "retstart", "", "seq_start", "", "query_key", "", "email", "", "report", "", "retmax", "" };
		ri.EFetchInterface(eFetchSequenceReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		// String[] expectedResultParameter = { "tseqset", "true", "gbset",
		// "true", "insdset", "true", "idlist", "true" };
		// assertArrayEquals(expectedResultParameter, actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleSequenceResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchJournals() {
		// prepare efetch operation
		ri.initEFetchOperation("journals");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// next fire a request
		String[] eFetchJournalsReq = { "id", "20318", "retstart", "", "webenv", "", "email", "", "querykey", "", "tool", "", "rettype", "", "retmax",
				"" };
		ri.EFetchInterface(eFetchJournalsReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleJournalsResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

	@Test
	public void test_eEfetchGene() {
		// prepare efetch operation
		ri.initEFetchOperation("gene");
		// first get the request parameter
		String[] actualReqParameter = ri.getRequestParameter("efetch");
		assertNotNull(actualReqParameter);
		// next fire a request
		String[] eFetchGeneReq = { "id", "214271", "retstart", "", "webenv", "", "email", "", "tool", "", "retmax", "", "querykey", "" };
		ri.EFetchInterface(eFetchGeneReq);
		// no error should be caused
		assertFalse(ri.isErrorCaused());
		String[] actualResultParameter = ri.getResultParameter();
		assertNotNull(actualResultParameter);
		for (int i = 0; i < actualResultParameter.length; i += 2) {
			System.out.println(actualResultParameter[i] + ": " + actualResultParameter[i + 1]);
			if (actualResultParameter[i + 1].equalsIgnoreCase(RInterface.VALUE_TRUE)) {
				// complex type
				String[] comp = ri.getComplexType(actualResultParameter[i]);
				assertNotNull(comp);
				for (String res : comp) {
					assertNotNull(res);
					File file = new File("ExampleOut/eFetchExampleGeneResult_" + actualResultParameter[i] + ".xml");
					try {
						FileUtils.writeStringToFile(file, res);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// simple type
				assertNotNull(ri.getSimpleType(actualResultParameter[i]));
			}
		}
	}

}
