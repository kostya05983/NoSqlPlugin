package org.jetspirit.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import org.jetspirit.ui.windows.NoSqlWindow

class ServerWindowFactory: ToolWindowFactory{

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val nosqlWindow = NoSqlWindow(project)
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(nosqlWindow.getContent(), "", false)
        toolWindow.contentManager.addContent(content)
    }
}