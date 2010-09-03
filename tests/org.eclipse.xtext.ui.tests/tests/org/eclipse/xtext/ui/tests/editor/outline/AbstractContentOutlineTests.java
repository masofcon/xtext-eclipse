/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

//TODO: reimplement with regard to new architecture

//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.resource.ContentHandler;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//import org.eclipse.jface.viewers.ILabelProvider;
//import org.eclipse.xtext.junit.AbstractXtextTests;
//import org.eclipse.xtext.resource.ILocationInFileProvider;
//import org.eclipse.xtext.resource.XtextResource;
//import org.eclipse.xtext.resource.XtextResourceSet;
//import org.eclipse.xtext.ui.editor.outline.old.DefaultContentOutlineNodeFactory;
//import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
//import org.eclipse.xtext.util.TextLocation;
//import org.eclipse.xtext.util.concurrent.IStateAccess;
//import org.eclipse.xtext.util.concurrent.IUnitOfWork;
//
///**
// * @author Michael Clay - Initial contribution and API
// * @author Sebastian Zarnekow
// */
//public abstract class AbstractContentOutlineTests extends AbstractXtextTests implements IStateAccess<XtextResource> {
//	protected EObject root;
//	protected EObject a1;
//	protected EObject a2;
//	protected DefaultContentOutlineNodeFactory contentOutlineNodeFactory;
//
//	private static ILocationInFileProvider locationProvider = new ILocationInFileProvider() {
//		public TextLocation getLocation(EObject obj) {
//			return new TextLocation(0, 0);
//		}
//
//		public TextLocation getLocation(EObject referenceOwner, EStructuralFeature feature, int indexInList) {
//			return new TextLocation(0, 0);
//		}
//	};
//
//	private static ILabelProvider labelProvider = new DefaultEObjectLabelProvider(null);
//	private XtextResource xtextResource;
//
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		XtextResourceSet resourceSet = get(XtextResourceSet.class);
//		
//		resourceSet.setClasspathURIContext(getClass());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//		Resource resource = resourceSet.createResource(URI
//				.createURI("classpath:/org/eclipse/xtext/ui/tests/editor/outline/transformer/simplestructure.xmi"),
//				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
//		resource.load(null);
//		root = resource.getContents().get(0);
//		a1 = root.eContents().get(0);
//		a2 = root.eContents().get(1);
//		xtextResource = new XtextResource(resource.getURI());
//		xtextResource.getContents().addAll(resource.getContents());
//		contentOutlineNodeFactory = new DefaultContentOutlineNodeFactory(labelProvider, locationProvider);
//	}
//	
//	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
//		try {
//			return work.exec(xtextResource);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
//		try {
//			return work.exec(xtextResource);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
