package com.lapots.directory.crawler.core.processor.xml

class FSXMLUtils {

    static def serializeFS(node, xml) {
        if (node.children) {
            xml.directory(name: node.data.name) {
                node.children.each {
                    serializeFS(it, xml)
                }
            }
        } else {
            xml."${node.data.size ? 'file' : 'directory'}"(name: node.data.name, size: node.data.size)
        }
    }

    static def wrapFS(output, xml) {
        xml."filesystem-root"(output)
    }
}
