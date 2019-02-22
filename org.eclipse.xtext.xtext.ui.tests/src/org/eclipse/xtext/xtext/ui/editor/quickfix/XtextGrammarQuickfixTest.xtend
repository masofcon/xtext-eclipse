/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix

import com.google.inject.Guice
import org.eclipse.xtext.XtextRuntimeModule
import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.shared.SharedStateModule
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.xtext.ui.Activator
import org.eclipse.xtext.xtext.ui.internal.XtextUIModuleInternal
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.SPACES_IN_KEYWORD

/**
 * @author loradd - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextGrammarQuickfixTest.InjectorProvider)
class XtextGrammarQuickfixTest extends AbstractQuickfixTest {

	@Test
	def testFixKeywordWithSpaces() {
		grammarWithRules('''Model: ' a b c d ' a=ID;''').testQuickfixesOn(SPACES_IN_KEYWORD,
			new Quickfix("Fix keyword with spaces", "Fix keyword with spaces",
				grammarWithRules('''Model: 'a' 'b' 'c' 'd' a=ID;''')))
	}

	@Test
	def testFixEmptyKeywordWithSpaces() {
		grammarWithRules('''Model: '    ' a=ID;''').testQuickfixesOn(SPACES_IN_KEYWORD,
			new Quickfix("Fix keyword with spaces", "Fix keyword with spaces", grammarWithRules('''Model: '' a=ID;''')))
	}

	def private String grammarWithRules(CharSequence... rules) '''
		grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
		generate myDsl "http://www.xtext.org/mydsl/MyDsl"
		�rules.join('\n')�
	'''

	static class InjectorProvider implements IInjectorProvider {
		override getInjector() {
			Guice.createInjector(
				Modules2.mixin(new XtextRuntimeModule(), new XtextUIModuleInternal(Activator.getDefault()),
					new SharedStateModule()));
		}
	}

}
