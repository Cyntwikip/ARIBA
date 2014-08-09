package Home_Module;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class JIntField extends JTextField
{
	public JIntField(int cols) {
        super("",cols);
    }

        @Override
    protected Document createDefaultModel() {
        return new LetterDocument();
    }
    
    class LetterDocument extends PlainDocument {
        @Override
        public void insertString(int num,String str, AttributeSet a)
        throws BadLocationException
        {
            if(str==null) return;
            char [] before = str.toCharArray();
            String after = "";
            for(int i=0;i < before.length;i++)
            {
                if( (before[i]>='0' && before[i]<='9'))
                    after += before[i];
            }
            super.insertString(num,after,a);
        }
    }    
}