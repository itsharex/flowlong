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
package com.flowlong.bpm.engine.parser;

import com.flowlong.bpm.engine.assist.XmlUtils;
import com.flowlong.bpm.engine.model.NodeModel;
import com.flowlong.bpm.engine.model.TransitionModel;
import org.w3c.dom.Element;

import java.util.List;

/**
 * 抽象dom节点解析类
 * 完成通用的属性、变迁解析
 *
 * @author hubin
 * @since 1.0
 */
public abstract class AbstractNodeParser implements NodeParser {

    /**
     * 公共部分节点逻辑解析
     */
    protected <T extends NodeModel> T parse(T model, Element element) {
        model.setName(element.getAttribute(ATTR_NAME));
        model.setDisplayName(element.getAttribute(ATTR_DISPLAY_NAME));
        model.setLayout(element.getAttribute(ATTR_LAYOUT));
        model.setPreInterceptors(element.getAttribute(ATTR_PRE_INTERCEPTORS));
        model.setPostInterceptors(element.getAttribute(ATTR_POST_INTERCEPTORS));

        List<Element> transitions = XmlUtils.elements(element, NODE_TRANSITION);
        for (Element te : transitions) {
            TransitionModel transition = new TransitionModel();
            transition.setName(te.getAttribute(ATTR_NAME));
            transition.setDisplayName(te.getAttribute(ATTR_DISPLAY_NAME));
            transition.setTo(te.getAttribute(ATTR_TO));
            transition.setExpr(te.getAttribute(ATTR_EXPR));
            transition.setG(te.getAttribute(ATTR_G));
            transition.setOffset(te.getAttribute(ATTR_OFFSET));
            transition.setSource(model);
            model.getOutputs().add(transition);
        }
        return model;
    }
}
