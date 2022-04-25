/*
 * generated by Xtext 2.26.0
 */
package org.example.domainmodel.ui.quickfix;



import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.example.domainmodel.validation.DomainmodelValidator;

/**
 * Custom quickfixes.
 */

public class DomainmodelQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(DomainmodelValidator.INVALID_NAME)
	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
			public void apply(IModificationContext context) throws  org.eclipse.jface.text.BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
			}
		});
	}

}

// Debug shell: context.getXtextDocument().get()