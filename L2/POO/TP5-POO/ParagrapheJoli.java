public class ParagrapheJoli extends Paragraphe{
    private int longueurMax;

    ParagrapheJoli(int le){
		super() ; 
        this.longueurMax = le ;
        this.addChaine(new Espace(4));
		// paragraphe = new LinkedList<Ligne>();
        // if(le != 0 && le > 0) this.longueurMax == le;
	}

    public boolean isEmpty() {
		return paragraphe.size() == 0;
	}
	
	
    public void addChaine (ChaineCar x) {
		// if(paragraphe.size() == longueurMax) paragraphe.next().add(a);
        if (super.getLignes().getLast().len() + x.len() > maxWidth){
            super.getLignes().getLast().justifier(maxWidth);
            super.getLignes().add(new Ligne()) ;
        }
        super.addChaine(x);
    }

	
}
