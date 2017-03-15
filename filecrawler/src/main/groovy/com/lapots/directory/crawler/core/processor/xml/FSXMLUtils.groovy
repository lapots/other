package com.lapots.directory.crawler.core.processor.xml

import groovy.xml.MarkupBuilder

class FSXMLUtils {

    static def serializeFS(node, output, xml = new MarkupBuilder(output)) {
        if (node.children) {
            xml.directory(name: node.data.name)
            node.children.each {
                xml = serializeFS(it, output, xml)
            }
        } else {
            node.data.size ?
                    xml.file(name: node.data.name, size: node.data.size) :
                    xml.directory(name: node.data.name, "")
        }

        xml
    }

    static def wrapFS(output, xml) {
        xml."filesystem-root"(output)
    }
}
