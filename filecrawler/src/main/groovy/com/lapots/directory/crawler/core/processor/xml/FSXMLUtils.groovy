package com.lapots.directory.crawler.core.processor.xml

import groovy.xml.MarkupBuilder

class FSXMLUtils {

    static def serializeFS(node, output, xml = new MarkupBuilder(output)) {
        if (node.children) {
            node.children.each {
                xml = serializeFS(it, output, xml)
            }
        } else {
            node.data.size ?
                    xml.file(name: node.data.name, "") :
                    xml.directory(name: node.data.name, "")
        }
    }

    static def wrapFS(output, xml = new MarkupBuilder(output)) {
        xml."filesystem-root"(output.toString())
    }
}
