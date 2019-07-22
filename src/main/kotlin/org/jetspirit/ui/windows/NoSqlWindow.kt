package org.jetspirit.ui.windows

import com.intellij.openapi.Disposable
import com.intellij.openapi.actionSystem.ActionToolbarPosition
import com.intellij.openapi.project.Project
import com.intellij.ui.ToolbarDecorator
import com.intellij.ui.components.JBList
import org.jetspirit.ui.windows.actions.AddServerAction
import javax.swing.BorderFactory
import javax.swing.JPanel

class NoSqlWindow(private val project: Project) : Disposable {

    private var panel: JPanel = JPanel()
    private lateinit var toolbarDecorator: ToolbarDecorator
    private val jbList = JBList<JPanel>()

    init {
        toolbarDecorator = ToolbarDecorator.createDecorator(jbList)
        toolbarDecorator.setPanelBorder(BorderFactory.createEmptyBorder())
        toolbarDecorator.setToolbarPosition(ActionToolbarPosition.TOP)
        toolbarDecorator.addExtraAction(AddServerAction(project))

        val schemePanel = JPanel()
        schemePanel.add(toolbarDecorator.createPanel())
        panel.add(schemePanel)
    }

    fun getContent(): JPanel {
        return panel
    }


    override fun dispose() {
    }
}