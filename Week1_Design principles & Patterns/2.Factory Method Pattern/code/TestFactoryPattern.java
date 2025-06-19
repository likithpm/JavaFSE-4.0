public class TestFactoryPattern {
    static abstract class Document {
        public abstract void open();
    }
    static class WordDocument extends Document {
        public void open() {
            System.out.println("Opening Word Document...");
        }
    }
    static class PdfDocument extends Document {
        public void open() {
            System.out.println("Opening PDF Document...");
        }
    }
    static class ExcelDocument extends Document {
        public void open() {
            System.out.println("Opening Excel Document...");
        }
    }
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }
    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }
    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
    public static void main(String[] args) {
        DocumentFactory factory;

        factory = new WordDocumentFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        factory = new PdfDocumentFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        factory = new ExcelDocumentFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}
