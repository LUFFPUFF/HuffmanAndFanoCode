package startapplication;

import logic.calculatefanocode.calculate.CalculateFanoCode;
import logic.calculatefanocode.createdtree.CreateTreeFano;
import logic.calculatehuffmancode.createdtree.CreatedHuffmanTree;
import startapplication.configpath.ConfigPath;
import logic.stringcontent.StringContent;
import logic.util.Writer;

public class Start {

    public static void main(String[] args) {

        CreateTreeFano.create(CalculateFanoCode.getCodes(), ConfigPath.FILE_PATH_FANO);
        CreatedHuffmanTree.create(ConfigPath.FILE_PATH_HUFFMAN);
        Writer.writeToTxtFile(ConfigPath.FILE_PATH_TXT, StringContent.getContent());

    }
}
