/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fourxtreme.visualcontroller;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@Messages({
    "LBL_DesignController_LOADER=Files of DesignController"
})
@MIMEResolver.NamespaceRegistration(
    displayName="#LBL_DesignController_LOADER",
    mimeType="text/controller+xml",
    elementNS={ "controller" }
)
@DataObject.Registration(
    mimeType = "text/controller+xml", 
    iconBase = "com/fourxtreme/visualcontroller/controller.png",
    displayName="#LBL_DesignController_LOADER",
    position=300
)
@ActionReferences({
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.OpenAction"),
        position=100, 
        separatorAfter=200
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="Edit", id="org.openide.actions.CutAction"),
        position=300
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="Edit", id="org.openide.actions.CopyAction"),
        position=400,
        separatorAfter=500
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="Edit", id="org.openide.actions.DeleteAction"),
        position=600
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.RenameAction"),
        position=700,
        separatorAfter=800
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.SaveAsTemplateAction"),
        position=900,
        separatorAfter=1000
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.FileSystemAction"),
        position=1100,
        separatorAfter=1200
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.ToolsAction"),
        position=1300
    ),
    @ActionReference(
        path="Loaders/text/controller+xml/Actions", 
        id=@ActionID(category="System", id="org.openide.actions.PropertiesAction"),
        position=1400
    )
})
public class DesignControllerDataObject extends MultiDataObject {

    public DesignControllerDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/controller+xml", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(
        displayName = "#LBL_DesignController_EDITOR",
        iconBase = "com/fourxtreme/visualcontroller/controller.png",
        mimeType = "text/controller+xml",
        persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
        preferredID = "DesignController",
        position = 1000
    )
    @Messages("LBL_DesignController_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }

}
