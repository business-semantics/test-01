package com.smartkyc.test.test01.documents;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * Document parsing and generation libraries managed by test-01-bom.
 */
public final class DocumentLibraries {

	/** One public type of every library this module depends on (tika-parsers is a pom-only artifact). */
	public static final List<Class<?>> USED = List.of(
			org.htmlcleaner.HtmlCleaner.class,
			nu.validator.htmlparser.dom.HtmlDocumentBuilder.class,
			org.apache.pdfbox.pdmodel.PDDocument.class,
			org.apache.pdfbox.tools.ExtractText.class,
			org.bouncycastle.jce.provider.BouncyCastleProvider.class,
			org.bouncycastle.mail.smime.SMIMEUtil.class,
			org.bouncycastle.cert.X509CertificateHolder.class,
			com.rometools.rome.io.SyndFeedInput.class,
			org.apache.tika.Tika.class,
			org.apache.tika.parser.microsoft.OfficeParser.class,
			org.apache.poi.hssf.usermodel.HSSFWorkbook.class,
			org.apache.poi.hwpf.HWPFDocument.class,
			org.apache.poi.xssf.usermodel.XSSFWorkbook.class,
			org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook.class,
			org.w3c.css.sac.Parser.class,
			org.w3c.flute.parser.Parser.class,
			org.apache.batik.css.parser.Parser.class,
			org.cyberneko.html.HTMLConfiguration.class,
			org.jdom2.Document.class,
			org.apache.xml.security.Init.class);

	private DocumentLibraries() {
	}

	public static byte[] blankPdf(int pages) throws IOException {
		try (PDDocument document = new PDDocument(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			for (int i = 0; i < pages; i++) {
				document.addPage(new PDPage());
			}
			document.save(out);
			return out.toByteArray();
		}
	}
}
