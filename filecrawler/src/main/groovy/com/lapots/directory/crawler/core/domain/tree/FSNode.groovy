package com.lapots.directory.crawler.core.domain.tree

import com.lapots.directory.crawler.core.domain.FSEntity

/**
 * Node of tree filesystem. It can be either file or directory.
 * Directory has children but has no size,
 *      while file has size but has no children.
 */
class FSNode {
    FSEntity data
    def parent
    def children = []

    boolean isRoot() {
        parent == null
    }
}
