package com.kodekonveyor.integrationtests;

import java.io.StringReader;
import java.text.MessageFormat;

import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

class XmlTest {//NOPMD

  private final Processor processor = new Processor(false);

  private Boolean evaluate(final XdmNode xdm, final String expression) {
    XdmValue result;
    try {
      result = getProcessor().newXPathCompiler()
          .evaluate(
              expression,
              xdm
          );
    } catch (final SaxonApiException exception) {
      throw new IllegalArgumentException(exception);
    }
    if (result instanceof XdmAtomicValue)
      try {
        return ((XdmAtomicValue) result).getBooleanValue();
      } catch (final SaxonApiException exception) {
        throw new IllegalArgumentException(exception);
      }
    throw new IllegalArgumentException(
        MessageFormat.format(XmlTestData.BAD_XPATH_RETURN_TYPE, result)
    );
  }

  private Processor getProcessor() {
    return processor;
  }

  private XdmNode serialize(final Object entity) {
    final XmlMapper mapper = new XmlMapper();
    String taskXml;
    try {
      taskXml = mapper.writeValueAsString(entity);
    } catch (final JsonProcessingException exception) {
      throw new IllegalArgumentException(exception);
    }
    taskXml = taskXml.replaceAll(XmlTestData.LT_XML, XmlTestData.LT_PLAIN);
    taskXml = taskXml.replaceAll(XmlTestData.GT_XML, XmlTestData.GT_PLAIN);
    XdmNode xdm;
    try {
      xdm = getProcessor().newDocumentBuilder()
          .build(new StreamSource(new StringReader(taskXml)));
    } catch (final SaxonApiException exception) {
      throw new IllegalArgumentException(exception);
    }
    return xdm;
  }

}
