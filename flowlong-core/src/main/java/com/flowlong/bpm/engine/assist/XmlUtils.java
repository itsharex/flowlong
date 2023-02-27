/* Copyright 2023-2025 www.flowlong.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flowlong.bpm.engine.assist;

import com.flowlong.bpm.engine.exception.FlowLongException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * xml解析的帮助类
 *
 * @author hubin
 * @since 1.0
 */
public class XmlUtils {
    /**
     * DocumentBuilderFactory实例
     */
    private static DocumentBuilderFactory documentBuilderFactory = createDocumentBuilderFactory();

    /**
     * 获取DocumentBuilderFactory
     *
     * @return
     */
    private static DocumentBuilderFactory createDocumentBuilderFactory() {
        return DocumentBuilderFactory.newInstance();
    }

    public static DocumentBuilder createDocumentBuilder() {
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new FlowLongException("documentBuilder is null");
        }
    }

    /**
     * 从element元素查找所有tagName指定的子节点元素集合
     *
     * @param element 元素 {@see Element}
     * @param tagName 标签名称
     * @return
     */
    public static List<Element> elements(Element element, String tagName) {
        if (element == null || !element.hasChildNodes()) {
            return Collections.emptyList();
        }
        List<Element> elements = new ArrayList<>();
        for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;
                String childTagName = childElement.getNodeName();
                if (tagName.equals(childTagName))
                    elements.add(childElement);
            }
        }
        return elements;
    }
}
