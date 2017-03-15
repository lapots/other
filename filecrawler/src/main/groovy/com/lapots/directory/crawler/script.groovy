package com.lapots.directory.crawler

import com.lapots.directory.crawler.core.domain.FSEntity
import com.lapots.directory.crawler.core.domain.tree.FSNode
import com.lapots.directory.crawler.core.processor.xml.FSXMLUtils
import groovy.xml.MarkupBuilder

def xmlSample = """
    <filesystem-root>
        <directory name="folder">
            <directory name="users">
                <file name="document.docx"/>
            <directory>
            <file name="image.png"/>
        </directory>
    </filesystem-root>
"""

// create filesystem folder
def fsEntityDirectory = new FSEntity(name: 'folder')
def fsDirectoryNode = new FSNode(parent: null, data: fsEntityDirectory)

def fsEntityDirectory2 = new FSEntity(name: 'folder1')
def fsDirectoryNode2 = new FSNode(parent: fsDirectoryNode, data: fsEntityDirectory2)

// create filesystem file
def fsEntity = new FSEntity(name: 'basic.txt', size: 10) // file system entity
def fsEntityNode = new FSNode(data: fsEntity, parent: fsDirectoryNode)

def fsEntity2 = new FSEntity(name: 'file.png', size: 12)
def fsEntityNode2 = new FSNode(data: fsEntity2, parent: fsDirectoryNode2)
fsDirectoryNode2.children << fsEntityNode2

fsDirectoryNode.children << fsDirectoryNode2
fsDirectoryNode.children << fsEntityNode

def markupBuilder = new MarkupBuilder()
FSXMLUtils.serializeFS(fsDirectoryNode, markupBuilder)


println markupBuilder.toString()