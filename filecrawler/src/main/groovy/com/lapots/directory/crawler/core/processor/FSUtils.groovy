package com.lapots.directory.crawler.core.processor

class FSUtils {

    static long calculateSize(node, size = 0) {
        if (node.children) {
            node.children.each {
                size = calculateSize(it, size)
            }
        } else {
            size += node.data.size
        }

        size
    }
}
