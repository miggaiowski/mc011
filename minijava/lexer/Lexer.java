/* This file was generated by SableCC (http://www.sablecc.org/). */

package lexer;

import java.io.*;
import node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") PushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        int middle = (low + high) / 2;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            @SuppressWarnings("hiding") Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            @SuppressWarnings("hiding") Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            @SuppressWarnings("hiding") Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            @SuppressWarnings("hiding") Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            @SuppressWarnings("hiding") Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            @SuppressWarnings("hiding") Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            @SuppressWarnings("hiding") Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            @SuppressWarnings("hiding") Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            @SuppressWarnings("hiding") Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            @SuppressWarnings("hiding") Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            @SuppressWarnings("hiding") Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            @SuppressWarnings("hiding") Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            @SuppressWarnings("hiding") Token token = new18(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            @SuppressWarnings("hiding") Token token = new19(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            @SuppressWarnings("hiding") Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            @SuppressWarnings("hiding") Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            @SuppressWarnings("hiding") Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            @SuppressWarnings("hiding") Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            @SuppressWarnings("hiding") Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            @SuppressWarnings("hiding") Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            @SuppressWarnings("hiding") Token token = new26(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            @SuppressWarnings("hiding") Token token = new27(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            @SuppressWarnings("hiding") Token token = new28(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            @SuppressWarnings("hiding") Token token = new29(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 30:
                        {
                            @SuppressWarnings("hiding") Token token = new30(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 31:
                        {
                            @SuppressWarnings("hiding") Token token = new31(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 32:
                        {
                            @SuppressWarnings("hiding") Token token = new32(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 33:
                        {
                            @SuppressWarnings("hiding") Token token = new33(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 34:
                        {
                            @SuppressWarnings("hiding") Token token = new34(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 35:
                        {
                            @SuppressWarnings("hiding") Token token = new35(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 36:
                        {
                            @SuppressWarnings("hiding") Token token = new36(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 37:
                        {
                            @SuppressWarnings("hiding") Token token = new37(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 38:
                        {
                            @SuppressWarnings("hiding") Token token = new38(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TClassn(line, pos); }
    Token new1(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TExtends(line, pos); }
    Token new2(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPublic(line, pos); }
    Token new3(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TStatic(line, pos); }
    Token new4(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TVoid(line, pos); }
    Token new5(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMain(line, pos); }
    Token new6(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TString(line, pos); }
    Token new7(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TInt(line, pos); }
    Token new8(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBoolean(line, pos); }
    Token new9(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIf(line, pos); }
    Token new10(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TElse(line, pos); }
    Token new11(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TWhile(line, pos); }
    Token new12(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLength(line, pos); }
    Token new13(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNew(line, pos); }
    Token new14(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TTrue(line, pos); }
    Token new15(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TFalse(line, pos); }
    Token new16(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TReturn(line, pos); }
    Token new17(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TThis(line, pos); }
    Token new18(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TId(text, line, pos); }
    Token new19(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNumber(text, line, pos); }
    Token new20(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPlusop(line, pos); }
    Token new21(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMinusop(line, pos); }
    Token new22(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TTimesop(line, pos); }
    Token new23(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAnd(line, pos); }
    Token new24(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLess(line, pos); }
    Token new25(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEqual(line, pos); }
    Token new26(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNot(line, pos); }
    Token new27(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLBracket(line, pos); }
    Token new28(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRBracket(line, pos); }
    Token new29(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLBrace(line, pos); }
    Token new30(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRBrace(line, pos); }
    Token new31(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLParenthese(line, pos); }
    Token new32(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRParenthese(line, pos); }
    Token new33(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDot(line, pos); }
    Token new34(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSemicolon(line, pos); }
    Token new35(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TComma(line, pos); }
    Token new36(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBlank(text, line, pos); }
    Token new37(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPrint(line, pos); }
    Token new38(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TComment(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {33, 33, 5}, {38, 38, 6}, {40, 40, 7}, {41, 41, 8}, {42, 42, 9}, {43, 43, 10}, {44, 44, 11}, {45, 45, 12}, {46, 46, 13}, {47, 47, 14}, {48, 57, 15}, {59, 59, 16}, {60, 60, 17}, {61, 61, 18}, {65, 82, 19}, {83, 83, 20}, {84, 90, 19}, {91, 91, 21}, {93, 93, 22}, {97, 97, 19}, {98, 98, 23}, {99, 99, 24}, {100, 100, 19}, {101, 101, 25}, {102, 102, 26}, {103, 104, 19}, {105, 105, 27}, {106, 107, 19}, {108, 108, 28}, {109, 109, 29}, {110, 110, 30}, {111, 111, 19}, {112, 112, 31}, {113, 113, 19}, {114, 114, 32}, {115, 115, 33}, {116, 116, 34}, {117, 117, 19}, {118, 118, 35}, {119, 119, 36}, {120, 122, 19}, {123, 123, 37}, {125, 125, 38}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {},
            {{38, 38, 39}, },
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {{42, 42, 40}, {47, 47, 41}, },
            {{48, 57, 42}, },
            {},
            {},
            {},
            {{48, 57, 43}, {65, 90, 44}, {95, 95, 45}, {97, 122, 44}, },
            {{48, 95, -21}, {97, 115, 44}, {116, 116, 46}, {117, 120, 44}, {121, 121, 47}, {122, 122, 44}, },
            {},
            {},
            {{48, 95, -21}, {97, 110, 44}, {111, 111, 48}, {112, 122, 44}, },
            {{48, 95, -21}, {97, 107, 44}, {108, 108, 49}, {109, 122, 44}, },
            {{48, 107, -26}, {108, 108, 50}, {109, 119, 44}, {120, 120, 51}, {121, 122, 44}, },
            {{48, 95, -21}, {97, 97, 52}, {98, 122, 44}, },
            {{48, 95, -21}, {97, 101, 44}, {102, 102, 53}, {103, 109, 44}, {110, 110, 54}, {111, 122, 44}, },
            {{48, 95, -21}, {97, 100, 44}, {101, 101, 55}, {102, 122, 44}, },
            {{48, 95, -21}, {97, 97, 56}, {98, 122, 44}, },
            {{48, 100, -30}, {101, 101, 57}, {102, 122, 44}, },
            {{48, 95, -21}, {97, 116, 44}, {117, 117, 58}, {118, 122, 44}, },
            {{48, 100, -30}, {101, 101, 59}, {102, 122, 44}, },
            {{48, 115, -22}, {116, 116, 60}, {117, 122, 44}, },
            {{48, 95, -21}, {97, 103, 44}, {104, 104, 61}, {105, 113, 44}, {114, 114, 62}, {115, 122, 44}, },
            {{48, 110, -25}, {111, 111, 63}, {112, 122, 44}, },
            {{48, 103, -36}, {104, 104, 64}, {105, 122, 44}, },
            {},
            {},
            {},
            {{1, 41, 65}, {42, 42, 66}, {43, 127, 65}, },
            {{1, 9, 67}, {10, 10, 68}, {11, 127, 67}, },
            {{48, 57, 42}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 95, -21}, {97, 113, 44}, {114, 114, 69}, {115, 122, 44}, },
            {{48, 95, -21}, {97, 114, 44}, {115, 115, 70}, {116, 122, 44}, },
            {{48, 110, -25}, {111, 111, 71}, {112, 122, 44}, },
            {{48, 95, -21}, {97, 97, 72}, {98, 122, 44}, },
            {{48, 114, -49}, {115, 115, 73}, {116, 122, 44}, },
            {{48, 115, -22}, {116, 116, 74}, {117, 122, 44}, },
            {{48, 107, -26}, {108, 108, 75}, {109, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 115, -22}, {116, 116, 76}, {117, 122, 44}, },
            {{48, 95, -21}, {97, 109, 44}, {110, 110, 77}, {111, 122, 44}, },
            {{48, 95, -21}, {97, 104, 44}, {105, 105, 78}, {106, 122, 44}, },
            {{48, 95, -21}, {97, 118, 44}, {119, 119, 79}, {120, 122, 44}, },
            {{48, 95, -21}, {97, 97, 44}, {98, 98, 80}, {99, 122, 44}, },
            {{48, 115, -22}, {116, 116, 81}, {117, 122, 44}, },
            {{48, 95, -21}, {97, 97, 82}, {98, 122, 44}, },
            {{48, 104, -58}, {105, 105, 83}, {106, 122, 44}, },
            {{48, 116, -33}, {117, 117, 84}, {118, 122, 44}, },
            {{48, 104, -58}, {105, 105, 85}, {106, 122, 44}, },
            {{48, 104, -58}, {105, 105, 86}, {106, 122, 44}, },
            {{1, 127, -42}, },
            {{1, 41, 87}, {42, 42, 66}, {43, 46, 87}, {47, 47, 88}, {48, 127, 87}, },
            {{1, 127, -43}, },
            {},
            {{48, 104, -58}, {105, 105, 89}, {106, 122, 44}, },
            {{48, 115, -22}, {116, 116, 90}, {117, 122, 44}, },
            {{48, 107, -26}, {108, 108, 91}, {109, 122, 44}, },
            {{48, 114, -49}, {115, 115, 92}, {116, 122, 44}, },
            {{48, 100, -30}, {101, 101, 93}, {102, 122, 44}, },
            {{48, 100, -30}, {101, 101, 94}, {102, 122, 44}, },
            {{48, 114, -49}, {115, 115, 95}, {116, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 95, -21}, {97, 102, 44}, {103, 103, 96}, {104, 122, 44}, },
            {{48, 109, -57}, {110, 110, 97}, {111, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 107, -26}, {108, 108, 98}, {109, 122, 44}, },
            {{48, 116, -33}, {117, 117, 99}, {118, 122, 44}, },
            {{48, 115, -22}, {116, 116, 100}, {117, 122, 44}, },
            {{48, 114, -49}, {115, 115, 101}, {116, 122, 44}, },
            {{48, 100, -30}, {101, 101, 102}, {102, 122, 44}, },
            {{48, 95, -21}, {97, 99, 44}, {100, 100, 103}, {101, 122, 44}, },
            {{48, 107, -26}, {108, 108, 104}, {109, 122, 44}, },
            {{1, 41, 105}, {42, 42, 106}, {43, 127, 105}, },
            {},
            {{48, 109, -57}, {110, 110, 107}, {111, 122, 44}, },
            {{48, 100, -30}, {101, 101, 108}, {102, 122, 44}, },
            {{48, 100, -30}, {101, 101, 109}, {102, 122, 44}, },
            {{48, 114, -49}, {115, 115, 110}, {116, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 109, -57}, {110, 110, 111}, {111, 122, 44}, },
            {{48, 100, -30}, {101, 101, 112}, {102, 122, 44}, },
            {{48, 115, -22}, {116, 116, 113}, {117, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 104, -58}, {105, 105, 114}, {106, 122, 44}, },
            {{48, 113, -48}, {114, 114, 115}, {115, 122, 44}, },
            {{48, 104, -58}, {105, 105, 116}, {106, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 100, -30}, {101, 101, 117}, {102, 122, 44}, },
            {{1, 127, -89}, },
            {{1, 41, 87}, {42, 42, 106}, {43, 127, -68}, },
            {{48, 102, -79}, {103, 103, 118}, {104, 122, 44}, },
            {{48, 95, -21}, {97, 108, 44}, {109, 109, 119}, {110, 122, 44}, },
            {{48, 95, -21}, {97, 97, 120}, {98, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 99, -87}, {100, 100, 121}, {101, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 103, -36}, {104, 104, 122}, {105, 122, 44}, },
            {{48, 95, -21}, {97, 98, 44}, {99, 99, 123}, {100, 122, 44}, },
            {{48, 109, -57}, {110, 110, 124}, {111, 122, 44}, },
            {{48, 98, -116}, {99, 99, 125}, {100, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{46, 46, 126}, {48, 122, -21}, },
            {{48, 109, -57}, {110, 110, 127}, {111, 122, 44}, },
            {{48, 114, -49}, {115, 115, 128}, {116, 122, 44}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{111, 111, 129}, },
            {{48, 122, -21}, },
            {{48, 122, -21}, },
            {{117, 117, 130}, },
            {{116, 116, 131}, },
            {{46, 46, 132}, },
            {{112, 112, 133}, },
            {{114, 114, 134}, },
            {{105, 105, 135}, },
            {{110, 110, 136}, },
            {{116, 116, 137}, },
            {{108, 108, 138}, },
            {{110, 110, 139}, },
            {},
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {36, 36, 36, 36, 36, 26, -1, 31, 32, 22, 20, 35, 21, 33, -1, 19, 34, 24, 25, 18, 18, 27, 28, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 29, 30, 23, -1, -1, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 9, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, -1, -1, -1, 38, 18, 18, 18, 18, 18, 18, 18, 7, 18, 18, 13, 18, 18, 18, 18, 18, 18, 18, -1, 38, 18, 18, 18, 18, 10, 18, 18, 18, 5, 18, 18, 18, 17, 14, 4, 18, -1, -1, 18, 18, 18, 0, 18, 15, 18, 18, 18, 18, 11, 6, 18, 18, 18, 12, 2, 16, 3, -1, 8, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}
