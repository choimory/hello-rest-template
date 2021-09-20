package com.choimory.helloresttemplate.common.parser;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonXmlParser {
    public static boolean isStringXml(String str){
        return StringUtils.startsWithIgnoreCase(str, "<");
    }

    public static List<Map<String, ?>> parseXmlStringToListMap(String xml, String targetTag) throws ParserConfigurationException, IOException, SAXException {
        List<Map<String, ?>> resultList = new ArrayList<>();

        /*BUILD DOCUMENT*/
        InputSource inputSource = new InputSource(new StringReader(xml));
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputSource);

        /*PARSE*/
        NodeList nodeList = document.getElementsByTagName(targetTag);
        for(int i = 0; i < nodeList.getLength(); i++){
            Map<String, String> nodeMap = new HashMap<>();
            Node node = nodeList.item(i);

            NodeList childNodeList = node.getChildNodes();
            for(int j = 0; j < childNodeList.getLength(); j++){
                Node childNode = childNodeList.item(j);
                if(childNode.getNodeType() == Node.ELEMENT_NODE){
                    nodeMap.put(childNode.getNodeName(), childNode.getTextContent());
                }
            }
            resultList.add(nodeMap);
        }

        return resultList;
    }
}
