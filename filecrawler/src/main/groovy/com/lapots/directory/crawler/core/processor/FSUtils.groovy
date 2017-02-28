package com.lapots.directory.crawler.core.processor

class FSUtils {

    static long calculateSize(node, size = 0) {
        println "Entering node: $node.data.name"
        if (node.children) {
            node.children.each {
                size = calculateSize(it, size)
            }
            size
        } else {
            calculateSingleSize(node, size)
        }
    }

    private static long calculateSingleSize(node, size) {
        size + node.data.size
    }
}
