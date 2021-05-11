package Chessy2;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Chessy2 {


    public static Scanner scan = new Scanner(System.in);
    private JPanel mainPanel;
    private JButton pos0;
    private JButton pos1;
    private JButton pos2;
    private JButton pos3;
    private JButton pos4;
    private JButton pos5;
    private JButton pos6;
    private JButton pos7;
    private JButton pos8;
    private JButton pos9;
    private JButton pos10;
    private JButton pos11;
    private JButton pos12;
    private JButton pos13;
    private JButton pos14;
    private JButton pos15;
    private JButton pos16;
    private JButton pos17;
    private JButton pos18;
    private JButton pos19;
    private JButton pos20;
    private JButton pos21;
    private JButton pos22;
    private JButton pos23;
    private JButton pos24;
    private JButton pos25;
    private JButton pos26;
    private JButton pos27;
    private JButton pos28;
    private JButton pos29;
    private JButton pos30;
    private JButton pos31;
    private JButton pos32;
    private JButton pos33;
    private JButton pos34;
    private JButton pos35;
    private JButton pos36;
    private JButton pos37;
    private JButton pos38;
    private JButton pos39;
    private JButton pos40;
    private JButton pos41;
    private JButton pos42;
    private JButton pos43;
    private JButton pos44;
    private JButton pos45;
    private JButton pos46;
    private JButton pos47;
    private JButton pos48;
    private JButton pos49;
    private JButton pos50;
    private JButton pos51;
    private JButton pos52;
    private JButton pos53;
    private JButton pos54;
    private JButton pos55;
    private JButton pos56;
    private JButton pos57;
    private JButton pos58;
    private JButton pos59;
    private JButton pos60;
    private JButton pos61;
    private JButton pos62;
    private JButton pos63;
    private JButton Start;
    public JTextArea Infromation_fält;
    private JButton Lisen;
    private JPanel Poton;
    private JButton switchButton;
    private final JButton[] positioner_fält_knappar = {pos0, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18,
            pos19, pos20, pos21, pos22, pos23, pos24, pos25, pos26, pos27, pos28, pos29, pos30, pos31, pos32, pos33, pos34, pos35, pos36, pos37, pos38, pos39, pos40, pos41,
            pos42, pos43, pos44, pos45, pos46, pos47, pos48, pos49, pos50, pos51, pos52, pos53, pos54, pos55, pos56, pos57, pos58, pos59, pos60, pos61, pos62, pos63, Lisen};

    String[] position = new String[64];
    boolean spelstatus = true;
    boolean sant_drag;
    public static LiveSpeechRecognizer recognizer;
    boolean chack = false;
    int ypos;
    int xpos;
    int tillypos;
    int tillxpos;
    int antaldrag = 0;
    boolean Vit_har_kung_rört_sig = false;
    boolean Svart_har_kung_rört_sig = false;
    private boolean förstaS = true;
    private SpeechResult result;
    String Information = "";
    boolean first = false;
    private boolean röst_eller_ej;

    public Chessy2() throws IOException {
        ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResource("/Smallcirkel.png")));
        ImageIcon vD = new ImageIcon(ImageIO.read(getClass().getResource("/vD.png")));
        ImageIcon sD = new ImageIcon(ImageIO.read(getClass().getResource("/sD.png")));
        ImageIcon vB = new ImageIcon(ImageIO.read(getClass().getResource("/vB.png")));
        ImageIcon sB = new ImageIcon(ImageIO.read(getClass().getResource("/sB.png")));
        ImageIcon sP = new ImageIcon(ImageIO.read(getClass().getResource("/sP.png")));
        ImageIcon vP = new ImageIcon(ImageIO.read(getClass().getResource("/vP.png")));
        ImageIcon vK = new ImageIcon(ImageIO.read(getClass().getResource("/vK.png")));
        ImageIcon sK = new ImageIcon(ImageIO.read(getClass().getResource("/sK.png")));
        ImageIcon sR = new ImageIcon(ImageIO.read(getClass().getResource("/sR.png")));
        ImageIcon vR = new ImageIcon(ImageIO.read(getClass().getResource("/vR.png")));
        ImageIcon vT = new ImageIcon(ImageIO.read(getClass().getResource("/vT.png")));
        ImageIcon sT = new ImageIcon(ImageIO.read(getClass().getResource("/sT.png")));
        ImageIcon panikvK = new ImageIcon(ImageIO.read(getClass().getResource("/panikvK.png")));
        ImageIcon paniksK = new ImageIcon(ImageIO.read(getClass().getResource("/paniksK.png")));



        Start.addActionListener(e ->
        {
            if (!first) {
                Arrays.fill(position, "  ");
                StartPositionAvPjäser(position);
                läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                //speatch shit
                // Loading Message
                // Logger
                //Logger logger = Logger.getLogger(TEEST.class.getName());
                // logger.log(Level.INFO, "Loading..\n");

                Configuration configuration = new Configuration();

                // Load model from the jar
                configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
                configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

                // Grammar
        /*-----------------------------------------------
        I filen test.gram kan ni beskriva syntaxen för de kommandon ni vill använda.
        Just nu funkar typ: "move a one to b two"
        -------------------------------------------------- */
                configuration.setGrammarPath("resource:/grammars");
                configuration.setGrammarName("test");
                configuration.setUseGrammar(true);

                try {
                    recognizer = new LiveSpeechRecognizer(configuration);
                } catch (IOException ex) {
                    //logger.log(Level.SEVERE, "Config corrupt", ex);
                }

                recognizer.startRecognition(true);

                System.out.println("Röst eller ej? j/n");

                röst_eller_ej = scan.next().equalsIgnoreCase("j");
                first = true;
                Start.setText("Antal drag?");
            } else {
                Information += antaldrag;
                läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
            }
        });


        ActionListener listener = e -> {


            sant_drag = false;

            if (röst_eller_ej) {
                do {
                    System.out.println("tala!");
                    Information += "tala!\n";
                    läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);

                    result = recognizer.getResult();
                    //System.out.println(result.getWords());
                    System.out.format("Hypothesis: %s\n", result.getHypothesis());
                    Information += result.getHypothesis() + "\n";
                    läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);

                } while (result.getHypothesis().length() < 10);

                /*
                if (((int) result.getHypothesis().charAt(5) == 'x'))
                    xpos = 4;
                else

                 */
                //xpos = ((int) result.getHypothesis().charAt(5)) - 97;

                switch (result.getHypothesis().split(" ")[1]) {
                    case ("alpha") -> xpos = 0;
                    case ("bravo") -> xpos = 1;
                    case ("delta") -> xpos = 3;
                    case ("echo") -> xpos = 4;
                    case ("foxtrot") -> xpos = 5;
                    case ("golf") -> xpos = 6;
                    case ("hotel") -> xpos = 7;
                    default -> xpos = 2;
                }


                switch (result.getHypothesis().split(" ")[2]) {
                    case ("one") -> ypos = 7;
                    case ("two") -> ypos = 6;
                    case ("four") -> ypos = 4;
                    case ("five") -> ypos = 3;
                    case ("six") -> ypos = 2;
                    case ("seven") -> ypos = 1;
                    case ("eight") -> ypos = 0;
                    default -> ypos = 5;
                }

                switch (result.getHypothesis().split(" ")[4]) {
                    case ("alpha") -> tillxpos = 0;
                    case ("bravo") -> tillxpos = 1;
                    case ("delta") -> tillxpos = 3;
                    case ("echo") -> tillxpos = 4;
                    case ("foxtrot") -> tillxpos = 5;
                    case ("golf") -> tillxpos = 6;
                    case ("hotel") -> tillxpos = 7;
                    default -> tillxpos = 2;
                }

                switch (result.getHypothesis().split(" ")[5]) {
                    case ("one") -> tillypos = 7;
                    case ("two") -> tillypos = 6;
                    case ("four") -> tillypos = 4;
                    case ("five") -> tillypos = 3;
                    case ("six") -> tillypos = 2;
                    case ("seven") -> tillypos = 1;
                    case ("eight") -> tillypos = 0;
                    default -> tillypos = 5;
                }
                förstaS = true;

            } else {


                String meta_data = (e.toString().substring(e.toString().indexOf(" javax.swing.JButton[,") + 22, e.toString().indexOf(",70x70")));
                if (förstaS) {
                    xpos = hittaXposAvKnapp(meta_data);
                    ypos = hittaYposAvKnapp(meta_data);
                    förstaS = false;
                } else {
                    tillxpos = hittaXposAvKnapp(meta_data);
                    tillypos = hittaYposAvKnapp(meta_data);
                    förstaS = true;
                }
            }


            if (förstaS) {
                /*
                //kollar om bonden bör ersättas med en drottning
                if (position[tillxpos + (tillypos * 8)].equals("vB") && tillypos == 7)
                    position[tillxpos + (tillypos * 8)] = UppgraderaBondenSvart();
                if (position[tillxpos + (tillypos * 8)].equals("sB") && tillypos == 0)
                    position[tillxpos] = UppgraderaBondenVit();


                 */

                String[] position_som_chakade = new String[64];
                System.arraycopy(position, 0, position_som_chakade, 0, 64);


                if (position[xpos + (ypos * 8)].charAt(0) == 'v' &&
                        (position[tillxpos + (tillypos * 8)].charAt(0) == 's' || position[tillxpos + (tillypos * 8)].equals("  ")))
                    sant_drag = true;

                if (position[xpos + (ypos * 8)].charAt(0) == 's' &&
                        (position[tillxpos + (tillypos * 8)].charAt(0) == 'v' || position[tillxpos + (tillypos * 8)].equals("  ")))
                    sant_drag = true;
//kollar vems tur det är att spela
                if (antaldrag % 2 == 1 && position[xpos + (ypos * 8)].charAt(0) == 'v')
                    sant_drag = false;
                if (antaldrag % 2 == 0 && position[xpos + (ypos * 8)].charAt(0) == 's')
                    sant_drag = false;


                if (!sant_drag) {

                    Information += "ERROR\nInkorekt datainmatning\n eller begrägeri\n";
                    System.out.println("ERROR\nInkorekt datainmatning eller begrägeri");
                    läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                }


                if (sant_drag) {
                    switch (position[xpos + (ypos * 8)].charAt(1)) {
                        case ('B') -> {
                            if (ReglerFörBonde(position, xpos, ypos, tillypos, tillxpos)) {
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                antaldrag++;
                            } else {
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                                läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                            }


                            //kollar om bonden bör ersättas med en drottning
                            if (position[tillxpos + (tillypos * 8)].equals("sB") && tillypos == 7)
                                position[tillxpos + (tillypos * 8)] = UppgraderaBondenSvart();
                            if (position[tillxpos + (tillypos * 8)].equals("vB") && tillypos == 0)
                                position[tillxpos] = UppgraderaBondenVit();


                        }
                        case ('T') -> {
                            if (ReglerFörTorn(ypos, tillypos, xpos, tillxpos) && ReglerFörSakerIVägenRakt(ypos, tillypos, xpos, tillxpos, position)) {
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                antaldrag++;

                            } else
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                            läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                        }
                        case ('R') -> {
                            if (ReglerFörRyttare(ypos, tillypos, xpos, tillxpos)) {
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                antaldrag++;
                            } else
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                            läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                        }
                        case ('K') -> {

                            if (ReglerFörKung(ypos, tillypos, xpos, tillxpos)) {
                                String[] temp = new String[64];
                                System.arraycopy(position, 0, temp, 0, 64);
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);

                                if (!under_attak(tillypos, tillxpos, tillypos, tillxpos, position, 'n')) {
                                    System.arraycopy(temp, 0, position, 0, 64);
                                    Information += "Där skulle du bli attakerad!\n";
                                } else {
                                    antaldrag++;
                                    if (position[tillxpos + (tillypos * 8)].charAt(0) == 'v')
                                        Vit_har_kung_rört_sig = true;
                                    else
                                        Svart_har_kung_rört_sig = true;
                                }

                            } else if (Casteling(ypos, xpos, tillxpos, position, Vit_har_kung_rört_sig, Svart_har_kung_rört_sig)) {
                                antaldrag++;
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                if (position[tillxpos + 1 + (tillypos * 8)].charAt(1) == 'T') {
                                    xpos += 3;
                                    tillxpos -= 1;
                                } else {
                                    xpos -= 4;
                                    tillxpos += 1;
                                }
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);

                            } else {
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                                läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                            }
                        }
                        case ('D') -> {
                            if (ReglerFörDrottning(ypos, tillypos, xpos, tillxpos) && ReglerFörSakerIVägenDiagonalt(ypos, tillypos, xpos, tillxpos, position) && ReglerFörSakerIVägenRakt(ypos, tillypos, xpos, tillxpos, position)) {
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                antaldrag++;
                            } else
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                            läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                        }
                        case ('P') -> {
                            if (ReglerFörPräst(ypos, tillypos, xpos, tillxpos) && ReglerFörSakerIVägenDiagonalt(ypos, tillypos, xpos, tillxpos, position)) {
                                FlyttaPåPjäs(position, xpos, ypos, tillypos, tillxpos);
                                antaldrag++;
                            } else
                                Information += "Olagligt beslut\nVänligen försök igen\n";

                            läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                        }
                    }


                    //kollar om båda kungar fortfarande finns på fältet, & om inte kommer en vinnare att deklareras
                    if (Arrays.stream(position).noneMatch(s -> s.contains("vK")) || Arrays.stream(position).noneMatch(s -> s.contains("sK"))) {
                        spelstatus = false;
                        if ((Arrays.stream(position).noneMatch(s -> s.contains("vK")))) {

                            Information += "Svart vann!!\nEfter " + antaldrag + " antal drag\n";
                            System.out.printf("Svart vann!!\nEfter %d antal drag", antaldrag);
                        } else {

                            Information += "Vit vann!!\nEfter " + antaldrag + " antal drag\n";
                            System.out.printf("Vit vann!!\nEfter %d antal drag", antaldrag);
                        }
                        läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                    }
                    läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);


                    if (schackad(antaldrag - 1, position)) {
                        antaldrag--;
                        System.arraycopy(position_som_chakade, 0, position, 0, 64);
                        Information += "Din kung har blivit schackad\n";
                        läggUtBrädan(position, vD, sD, vB, sB, sP, vP, vK, sK, sR, vR, vT, sT, paniksK, panikvK);
                    } else chack = false;
                }
            }

        };

        {
            pos0.addActionListener(listener);
            pos1.addActionListener(listener);
            pos2.addActionListener(listener);
            pos3.addActionListener(listener);
            pos4.addActionListener(listener);
            pos5.addActionListener(listener);
            pos6.addActionListener(listener);
            pos7.addActionListener(listener);
            pos8.addActionListener(listener);
            pos9.addActionListener(listener);
            pos10.addActionListener(listener);
            pos11.addActionListener(listener);
            pos12.addActionListener(listener);
            pos13.addActionListener(listener);
            pos14.addActionListener(listener);
            pos15.addActionListener(listener);
            pos16.addActionListener(listener);
            pos17.addActionListener(listener);
            pos18.addActionListener(listener);
            pos19.addActionListener(listener);
            pos20.addActionListener(listener);
            pos21.addActionListener(listener);
            pos22.addActionListener(listener);
            pos23.addActionListener(listener);
            pos24.addActionListener(listener);
            pos25.addActionListener(listener);
            pos26.addActionListener(listener);
            pos27.addActionListener(listener);
            pos28.addActionListener(listener);
            pos29.addActionListener(listener);
            pos30.addActionListener(listener);
            pos31.addActionListener(listener);
            pos32.addActionListener(listener);
            pos33.addActionListener(listener);
            pos34.addActionListener(listener);
            pos35.addActionListener(listener);
            pos36.addActionListener(listener);
            pos37.addActionListener(listener);
            pos38.addActionListener(listener);
            pos39.addActionListener(listener);
            pos40.addActionListener(listener);
            pos41.addActionListener(listener);
            pos42.addActionListener(listener);
            pos43.addActionListener(listener);
            pos44.addActionListener(listener);
            pos45.addActionListener(listener);
            pos46.addActionListener(listener);
            pos47.addActionListener(listener);
            pos48.addActionListener(listener);
            pos49.addActionListener(listener);
            pos50.addActionListener(listener);
            pos51.addActionListener(listener);
            pos52.addActionListener(listener);
            pos53.addActionListener(listener);
            pos54.addActionListener(listener);
            pos55.addActionListener(listener);
            pos56.addActionListener(listener);
            pos57.addActionListener(listener);
            pos58.addActionListener(listener);
            pos59.addActionListener(listener);
            pos60.addActionListener(listener);
            pos61.addActionListener(listener);
            pos62.addActionListener(listener);
            pos63.addActionListener(listener);
        }
        Lisen.addActionListener(listener);
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                antaldrag++;
            }
        });
    }


    private static boolean schackad(int antaldrag, String[] position) {
        int position_av_kung = 0;
        boolean chack = false;
        if (antaldrag % 2 == 1) {
            while (!position[position_av_kung].equals("sK")) {
                position_av_kung++;
            }
            if (!under_attak(0, 0, position_av_kung / 8, position_av_kung - (position_av_kung / 8) * 8, position, 's'))
                chack = true;
        } else {
            while (!position[position_av_kung].equals("vK")) {
                position_av_kung++;
            }
            if (!under_attak(0, 0, position_av_kung / 8, position_av_kung - (position_av_kung / 8) * 8, position, 'v'))
                chack = true;
        }
        return chack;
    }


    private static void StartPositionAvPjäser(String[] position) {
        //String[] position = new String[64];
        for (int i = 0; i < 8; i++) {
            position[8 + i] = "sB";
        }
        for (int i = 0; i < 8; i++) {
            position[(8 * 6) + i] = "vB";
        }
        position[0] = "sT";
        position[7] = "sT";
        position[1] = "sR";
        position[6] = "sR";
        position[2] = "sP";
        position[5] = "sP";
        position[4] = "sK";
        position[3] = "sD";


        position[56] = "vT";
        position[63] = "vT";
        position[57] = "vR";
        position[62] = "vR";
        position[58] = "vP";
        position[61] = "vP";
        position[60] = "vK";
        position[59] = "vD";
    }


    private void läggUtBrädan(String[] position, ImageIcon vD, ImageIcon
            sD, ImageIcon vB, ImageIcon sB, ImageIcon sP, ImageIcon vP, ImageIcon vK, ImageIcon
                                      sK, ImageIcon sR, ImageIcon vR, ImageIcon vT, ImageIcon sT, ImageIcon paniksK, ImageIcon panikvK) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (position[j + (i * 8)]) {
                    case ("vD") -> positioner_fält_knappar[j + (i * 8)].setIcon(vD);
                    case ("sD") -> positioner_fält_knappar[j + (i * 8)].setIcon(sD);
                    case ("vB") -> positioner_fält_knappar[j + (i * 8)].setIcon(vB);
                    case ("sB") -> positioner_fält_knappar[j + (i * 8)].setIcon(sB);
                    case ("sP") -> positioner_fält_knappar[j + (i * 8)].setIcon(sP);
                    case ("vP") -> positioner_fält_knappar[j + (i * 8)].setIcon(vP);
                    case ("vK") -> {

                        if (schackad(0, position))
                            positioner_fält_knappar[j + (i * 8)].setIcon(panikvK);

                        else
                            positioner_fält_knappar[j + (i * 8)].setIcon(vK);
                    }
                    case ("sK") -> {
                        if (schackad(1, position))
                            positioner_fält_knappar[j + (i * 8)].setIcon(paniksK);

                        else
                            positioner_fält_knappar[j + (i * 8)].setIcon(sK);

                    }
                    case ("sR") -> positioner_fält_knappar[j + (i * 8)].setIcon(sR);
                    case ("vR") -> positioner_fält_knappar[j + (i * 8)].setIcon(vR);
                    case ("vT") -> positioner_fält_knappar[j + (i * 8)].setIcon(vT);
                    case ("sT") -> positioner_fält_knappar[j + (i * 8)].setIcon(sT);
                    default -> positioner_fält_knappar[j + (i * 8)].setIcon(null);
                }
            }
        }
        Infromation_fält.setText(Information);


    }

    private static Integer stringTillTal(String text) {

        int tal;
        ParsePosition parsePosition = new ParsePosition(0);
        if (NumberFormat.getInstance().parse(text, parsePosition) != null) {
            parsePosition = new ParsePosition(0);
            tal = NumberFormat.getInstance().parse(text, parsePosition).intValue();
        } else return null;

        //om en bokstav finns kommer den att återkomma med null
        if (parsePosition.getIndex() == text.length())
            return tal;
        else return null;
    }

    private static int hittaXposAvKnapp(String nummer) {
        int xpos = 0;
        for (int i = 20; i < 511; i += 70) {
            if (i == Objects.requireNonNull(stringTillTal(nummer.substring(0, nummer.indexOf(","))))) {
                xpos = (i - 20) / 70;
                break;
            }
        }

        return xpos;
    }

    private static int hittaYposAvKnapp(String nummer) {
        int ypos = 0;

        for (int i = 0; i < 491; i += 70) {
            if (i == Objects.requireNonNull(stringTillTal(nummer.substring(nummer.indexOf(",") + 1)))) {
                ypos = (i) / 70;
                break;
            }
        }


        return ypos;
    }

    private static String UppgraderaBondenVit() {
        System.out.println("Hur skulle du vilja uppgradera till bonde?\nT?\nR?\nP?\nD?");
        switch (scan.next().toUpperCase()) {
            case ("T") -> {
                return ("vT");
            }
            case ("R") -> {
                return ("vR");
            }
            case ("P") -> {
                return ("vP");
            }
            default -> {
                return ("vD");
            }
        }
    }

    private static String UppgraderaBondenSvart() {
        System.out.println("Hur skulle du vilja uppgradera till bonde?\nT?\nR?\nP?\nD?");
        switch (scan.next().toUpperCase()) {
            case ("T") -> {
                return ("sT");
            }
            case ("R") -> {
                return ("sR");
            }
            case ("P") -> {
                return ("sP");
            }
            default -> {
                return ("sD");
            }
        }
    }

    private static void FlyttaPåPjäs(String[] position, int xpos, int ypos, int tillypos, int tillxpos) {
        position[tillxpos + (tillypos * 8)] = position[xpos + (ypos * 8)];
        position[xpos + (ypos * 8)] = "  ";
    }

    private static boolean ReglerFörBonde(String[] position, int xpos, int ypos, int tillypos, int tillxpos) {

        //vita
        if (position[xpos + (ypos * 8)].equals("vB")) {
            // om positionen diagonalt up är inte fri och du vill ett steg diagonalt return 1
            boolean b = ((xpos - 1) + ((ypos - 1) * 8)) == (tillxpos + ((tillypos) * 8));
            boolean b1 = ((xpos + 1) + ((ypos - 1) * 8)) == (tillxpos + ((tillypos) * 8));
            if (!position[(xpos - 1) + ((ypos - 1) * 8)].equals("  ") && b
                    || !position[(xpos + 1) + ((ypos - 1) * 8)].equals("  ") && b1)
                return (true);

            if (ypos == 6) {
                if ((tillypos - ypos) == -2 && xpos == tillxpos && position[(tillxpos) + ((tillypos) * 8)].equals("  ") && position[(tillxpos) + ((tillypos + 1) * 8)].equals("  "))
                    return (true);
            }
            if ((tillypos - ypos) == -1 && xpos == tillxpos && position[(tillxpos) + ((tillypos) * 8)].equals("  "))
                return (true);

            //en passant
            if (b && position[(tillxpos + ((tillypos + 1) * 8))].equals("sB") && ypos == 3 ||
                    b1 && position[(tillxpos + ((tillypos + 1) * 8))].equals("sB") && ypos == 3) {
                position[(tillxpos + ((tillypos + 1) * 8))] = "  ";
                return (true);
            }
        }

        //svarta
        if (position[xpos + (ypos * 8)].equals("sB")) {
            // om positionen diagonalt ner är inte fri och du vill ett steg diagonalt return 1
            boolean b = ((xpos - 1) + ((ypos + 1) * 8)) == ((tillxpos + ((tillypos) * 8)));
            boolean b1 = ((xpos + 1) + ((ypos + 1) * 8)) == ((tillxpos + ((tillypos) * 8)));
            if (!position[(xpos - 1) + ((ypos + 1) * 8)].equals("  ") && b
                    || !position[(xpos + 1) + ((ypos + 1) * 8)].equals("  ") && b1)
                return (true);

            if (ypos == 1) {
                if ((tillypos - ypos) == 2 && xpos == tillxpos && position[(tillxpos + ((tillypos) * 8))].equals("  ") && position[(tillxpos) + ((tillypos - 1) * 8)].equals("  "))
                    return (true);
            }
            if ((tillypos - ypos) == 1 && xpos == tillxpos && position[(tillxpos) + ((tillypos) * 8)].equals("  "))
                return (true);

            //en passant
            if ((b && position[(tillxpos + ((tillypos - 1) * 8))].equals("vB")) && ypos == 5 ||
                    (b1 && position[(tillxpos + ((tillypos - 1) * 8))].equals("vB")) && ypos == 5) {
                position[(tillxpos + ((tillypos - 1) * 8))] = "  ";
                return (true);
            }
        }
        return (false);

    }

    private static boolean ReglerFörTorn(int ypos, int tillypos, int xpos, int tillxpos) {
        return ypos == tillypos || xpos == tillxpos;
    }

    private static boolean ReglerFörRyttare(int ypos, int tillypos, int xpos, int tillxpos) {
        if (ypos == tillypos + 2 && (xpos == tillxpos + 1 || xpos == tillxpos - 1))
            return (true);
        if (ypos == tillypos - 2 && (xpos == tillxpos + 1 || xpos == tillxpos - 1))
            return (true);
        if (xpos == tillxpos - 2 && (ypos == tillypos + 1 || ypos == tillypos - 1))
            return (true);
        return xpos == tillxpos + 2 && (ypos == tillypos + 1 || ypos == tillypos - 1);
        //fortsätt att göra en åt varje riktning
    }

    private static boolean ReglerFörKung(int ypos, int tillypos, int xpos, int tillxpos) {
        return (((ypos == tillypos - 1 || ypos == tillypos + 1) && (xpos == tillxpos)) || ((xpos == tillxpos + 1 || xpos == tillxpos - 1) && (ypos == tillypos))) ||
                (xpos == tillxpos - 1 && ypos == tillypos + 1) || (xpos == tillxpos - 1 && ypos == tillypos - 1) ||
                (xpos == tillxpos + 1 && ypos == tillypos - 1) || (xpos == tillxpos + 1 && ypos == tillypos + 1);

    }

    private static boolean ReglerFörDrottning(int ypos, int tillypos, int xpos, int tillxpos) {
        if ((ypos == tillypos || xpos == tillxpos))
            return (true);
        for (int i = 0; i < 8; i++) {
            if ((xpos == tillxpos + i && ypos == tillypos + i) ||
                    (xpos == tillxpos - i && ypos == tillypos + i) || (xpos == tillxpos - i && ypos == tillypos - i) ||
                    (xpos == tillxpos + i && ypos == tillypos - i))
                return (true);
        }
        return (false);
    }

    private static boolean ReglerFörPräst(int ypos, int tillypos, int xpos, int tillxpos) {
        for (int i = 0; i < 8; i++) {
            if ((xpos == tillxpos + i && ypos == tillypos + i) ||
                    (xpos == tillxpos - i && ypos == tillypos + i) || (xpos == tillxpos - i && ypos == tillypos - i) ||
                    (xpos == tillxpos + i && ypos == tillypos - i))
                return (true);
        }
        return (false);
    }

    private static boolean ReglerFörSakerIVägenRakt(int ypos, int tillypos, int xpos, int tillxpos, String[]
            position) {
        if (ypos == tillypos) {
            for (int i = 0; i < Math.abs(xpos - tillxpos) - 1; i++) {
                if (!position[(tillxpos + (tillypos * 8)) + ((i + 1) * (xpos - tillxpos) / Math.abs(xpos - tillxpos))].equals("  "))
                    return (false);
            }
        }
        if (xpos == tillxpos) {
            for (int i = 0; i < Math.abs(ypos - tillypos) - 1; i++) {
                if (!position[(tillxpos + (tillypos * 8)) + ((8 + (8 * i)) * ((ypos - tillypos) / Math.abs(ypos - tillypos)))].equals("  "))
                    return (false);
            }
        }
        return (true);
    }

    private static boolean ReglerFörSakerIVägenDiagonalt(int ypos, int tillypos, int xpos, int tillxpos, String[]
            position) {
        //up höger
        if (xpos - tillxpos < 0 && ypos - tillypos > 0) {
            for (int i = 0; i < Math.abs(ypos - tillypos) - 1; i++) {
                if (!position[((tillxpos - i - 1) + ((tillypos + i + 1) * 8))].equals("  ")) {
                    return (false);
                }
            }
        }
        //up vänster
        if (xpos - tillxpos > 0 && ypos - tillypos > 0) {
            for (int i = 0; i < Math.abs(ypos - tillypos) - 1; i++) {
                if (!position[((tillxpos + i + 1) + ((tillypos + i + 1) * 8))].equals("  ")) {
                    return (false);
                }
            }
        }
        //ner höger
        if (xpos - tillxpos < 0 && ypos - tillypos < 0) {
            for (int i = 0; i < Math.abs(ypos - tillypos) - 1; i++) {
                if (!position[((tillxpos - i - 1) + ((tillypos - i - 1) * 8))].equals("  ")) {
                    return (false);
                }
            }
        }


        //ner vänster
        if (xpos - tillxpos > 0 && ypos - tillypos < 0) {
            for (int i = 0; i < Math.abs(ypos - tillypos) - 1; i++) {
                if (!position[((tillxpos + i + 1) + ((tillypos - i - 1) * 8))].equals("  ")) {
                    return (false);
                }
            }
        }

        return (true);
    }

    private static boolean Casteling(int ypos, int xpos, int tillxpos, String[] position,
                                     boolean Vit_har_kung_rört_sig, boolean Svart_har_kung_rört_sig) {


        if (position[xpos + (ypos * 8)].charAt(0) == 'v') {

            if ((xpos == tillxpos + 2 && position[tillxpos - 2 + (ypos * 8)].charAt(1) == 'T') && !Vit_har_kung_rört_sig && position[56].equals("vT")
                    && position[xpos - 1 + (ypos * 8)].equals("  ") && position[xpos - 2 + (ypos * 8)].equals("  ") && position[xpos - 3 + (ypos * 8)].equals("  ") &&
                    under_attak(0, 0, ypos, xpos - 1, position, 'v') &&
                    under_attak(0, 0, ypos, xpos - 2, position, 'v') &&
                    under_attak(0, 0, ypos, xpos - 3, position, 'v')) {
                return true;

            } else
                return (xpos == tillxpos - 2) && (position[tillxpos + 1 + (ypos * 8)].charAt(1) == 'T') && !Vit_har_kung_rört_sig && position[63].equals("vT")
                        && position[xpos + 1 + (ypos * 8)].equals("  ") && position[xpos + 2 + (ypos * 8)].equals("  ") &&
                        under_attak(0, 0, ypos, xpos + 1, position, 'v') &&
                        under_attak(0, 0, ypos, xpos + 2, position, 'v');
        } else {
            if ((xpos == tillxpos + 2 && position[tillxpos - 2 + (ypos * 8)].charAt(1) == 'T') && !Svart_har_kung_rört_sig && position[0].equals("sT")
                    && position[xpos - 1 + (ypos * 8)].equals("  ") && position[xpos - 2 + (ypos * 8)].equals("  ") && position[xpos - 3 + (ypos * 8)].equals("  ") &&
                    under_attak(0, 0, ypos, xpos - 1, position, 's') &&
                    under_attak(0, 0, ypos, xpos - 2, position, 's') &&
                    under_attak(0, 0, ypos, xpos - 3, position, 's')) {
                return true;

            } else
                return (xpos == tillxpos - 2) && (position[tillxpos + 1 + (ypos * 8)].charAt(1) == 'T') && !Svart_har_kung_rört_sig && position[7].equals("sT")
                        && position[xpos + 1 + (ypos * 8)].equals("  ") && position[xpos + 2 + (ypos * 8)].equals("  ") &&
                        under_attak(0, 0, ypos, xpos + 1, position, 's') &&
                        under_attak(0, 0, ypos, xpos + 2, position, 's');
        }
    }

    private static boolean under_attak(int ypos, int xpos, int tillypos, int tillxpos, String[] position, char pass) {
        if (pass == 'n')
            pass = position[xpos + (ypos * 8)].charAt(0);
        if (pass == 'v') {
            for (int i = 0; i <= 63; i++) {
                switch (position[i]) {
                    case ("sP") -> {
                        if (ReglerFörPräst(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenDiagonalt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("sR") -> {
                        if (ReglerFörRyttare(i / 8, tillypos, i - (i / 8) * 8, tillxpos))
                            return false;
                    }
                    case ("sD") -> {
                        if (ReglerFörDrottning(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenDiagonalt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position) && ReglerFörSakerIVägenRakt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("sB") -> {
                        if (ReglerFörBonde(position, i - (i / 8) * 8, i / 8, tillypos, tillxpos))
                            return false;
                    }
                    case ("sT") -> {
                        if (ReglerFörTorn(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenRakt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("sK") -> {
                        if (ReglerFörKung(i / 8, tillypos, i - (i / 8) * 8, tillxpos))
                            return false;
                    }

                }

            }
        } else {
            for (int i = 0; i <= 63; i++) {
                switch (position[i]) {
                    case ("vP") -> {
                        if (ReglerFörPräst(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenDiagonalt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("vR") -> {
                        if (ReglerFörRyttare(i / 8, tillypos, i - (i / 8) * 8, tillxpos))
                            return false;
                    }
                    case ("vD") -> {
                        if (ReglerFörDrottning(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenDiagonalt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position) && ReglerFörSakerIVägenRakt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("vB") -> {
                        if (ReglerFörBonde(position, i - (i / 8) * 8, i / 8, tillypos, tillxpos))
                            return false;
                    }
                    case ("vT") -> {
                        if (ReglerFörTorn(i / 8, tillypos, i - (i / 8) * 8, tillxpos) && ReglerFörSakerIVägenRakt(i / 8, tillypos, i - (i / 8) * 8, tillxpos, position))
                            return false;
                    }
                    case ("vK") -> {
                        if (ReglerFörKung(i / 8, tillypos, i - (i / 8) * 8, tillxpos))
                            return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        //Skapa ditt fönster
        String namn = "Chessy2.0";
        JFrame frame = new JFrame(namn);
        //Tala om att du vill kunna stänga ditt förnster med krysset i högra hörnet
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Ange storleken på ditt fönster och att det ska vara fast
        frame.setSize(1050, 650);
        frame.setResizable(false);
        //Positionera ditt fönster i mitten av skärmen
        frame.setLocationRelativeTo(null);

        //Skapa en instans av din den här klassen som hanterar din panel
        Chessy2 myForm = new Chessy2();
        //Lägg in din panel i programfönstret
        frame.setContentPane(myForm.mainPanel);
        //Visa programfönstret på skärmen
        frame.setVisible(true);

    }


}

