// Generated from FeatherweightJavaScript.g4 by ANTLR 4.8
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherweightJavaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, ELSE=7, WHILE=8, FUNCTION=9, 
		VAR=10, PRINT=11, INT=12, BOOL=13, NULL=14, MUL=15, DIV=16, ADD=17, SUB=18, 
		MOD=19, GT=20, LT=21, GE=22, LE=23, EQ=24, SEPARATOR=25, ASSIGN=26, ID=27, 
		NEWLINE=28, LINE_COMMENT=29, WS=30, BLOCK_COMMENT=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "ELSE", "WHILE", "FUNCTION", 
			"VAR", "PRINT", "INT", "BOOL", "NULL", "MUL", "DIV", "ADD", "SUB", "MOD", 
			"GT", "LT", "GE", "LE", "EQ", "SEPARATOR", "ASSIGN", "ID", "NEWLINE", 
			"LINE_COMMENT", "WS", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'{'", "'}'", "'if'", "'else'", "'while'", 
			"'function'", "'var'", "'print'", null, null, "'null'", "'*'", "'/'", 
			"'+'", "'-'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "IF", "ELSE", "WHILE", "FUNCTION", 
			"VAR", "PRINT", "INT", "BOOL", "NULL", "MUL", "DIV", "ADD", "SUB", "MOD", 
			"GT", "LT", "GE", "LE", "EQ", "SEPARATOR", "ASSIGN", "ID", "NEWLINE", 
			"LINE_COMMENT", "WS", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FeatherweightJavaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FeatherweightJavaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00cf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\ro\n\r\f\r\16\rr\13\r\3\r\5"+
		"\ru\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0080\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\7\34\u00a4\n\34\f\34\16\34\u00a7\13\34\3"+
		"\35\5\35\u00aa\n\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00b4"+
		"\n\36\f\36\16\36\u00b7\13\36\3\36\3\36\3\37\6\37\u00bc\n\37\r\37\16\37"+
		"\u00bd\3\37\3\37\3 \3 \3 \3 \7 \u00c6\n \f \16 \u00c9\13 \3 \3 \3 \3 "+
		"\3 \3\u00c7\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!\3\2\b\3\2\63;\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2"+
		"\f\f\17\17\4\2\13\13\"\"\2\u00d6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2"+
		"\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17N\3\2\2\2\21"+
		"S\3\2\2\2\23Y\3\2\2\2\25b\3\2\2\2\27f\3\2\2\2\31t\3\2\2\2\33\177\3\2\2"+
		"\2\35\u0081\3\2\2\2\37\u0086\3\2\2\2!\u0088\3\2\2\2#\u008a\3\2\2\2%\u008c"+
		"\3\2\2\2\'\u008e\3\2\2\2)\u0090\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2"+
		"/\u0097\3\2\2\2\61\u009a\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2\2\2\67"+
		"\u00a1\3\2\2\29\u00a9\3\2\2\2;\u00af\3\2\2\2=\u00bb\3\2\2\2?\u00c1\3\2"+
		"\2\2AB\7*\2\2B\4\3\2\2\2CD\7+\2\2D\6\3\2\2\2EF\7.\2\2F\b\3\2\2\2GH\7}"+
		"\2\2H\n\3\2\2\2IJ\7\177\2\2J\f\3\2\2\2KL\7k\2\2LM\7h\2\2M\16\3\2\2\2N"+
		"O\7g\2\2OP\7n\2\2PQ\7u\2\2QR\7g\2\2R\20\3\2\2\2ST\7y\2\2TU\7j\2\2UV\7"+
		"k\2\2VW\7n\2\2WX\7g\2\2X\22\3\2\2\2YZ\7h\2\2Z[\7w\2\2[\\\7p\2\2\\]\7e"+
		"\2\2]^\7v\2\2^_\7k\2\2_`\7q\2\2`a\7p\2\2a\24\3\2\2\2bc\7x\2\2cd\7c\2\2"+
		"de\7t\2\2e\26\3\2\2\2fg\7r\2\2gh\7t\2\2hi\7k\2\2ij\7p\2\2jk\7v\2\2k\30"+
		"\3\2\2\2lp\t\2\2\2mo\t\3\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q"+
		"u\3\2\2\2rp\3\2\2\2su\7\62\2\2tl\3\2\2\2ts\3\2\2\2u\32\3\2\2\2vw\7v\2"+
		"\2wx\7t\2\2xy\7w\2\2y\u0080\7g\2\2z{\7h\2\2{|\7c\2\2|}\7n\2\2}~\7u\2\2"+
		"~\u0080\7g\2\2\177v\3\2\2\2\177z\3\2\2\2\u0080\34\3\2\2\2\u0081\u0082"+
		"\7p\2\2\u0082\u0083\7w\2\2\u0083\u0084\7n\2\2\u0084\u0085\7n\2\2\u0085"+
		"\36\3\2\2\2\u0086\u0087\7,\2\2\u0087 \3\2\2\2\u0088\u0089\7\61\2\2\u0089"+
		"\"\3\2\2\2\u008a\u008b\7-\2\2\u008b$\3\2\2\2\u008c\u008d\7/\2\2\u008d"+
		"&\3\2\2\2\u008e\u008f\7\'\2\2\u008f(\3\2\2\2\u0090\u0091\7@\2\2\u0091"+
		"*\3\2\2\2\u0092\u0093\7>\2\2\u0093,\3\2\2\2\u0094\u0095\7@\2\2\u0095\u0096"+
		"\7?\2\2\u0096.\3\2\2\2\u0097\u0098\7>\2\2\u0098\u0099\7?\2\2\u0099\60"+
		"\3\2\2\2\u009a\u009b\7?\2\2\u009b\u009c\7?\2\2\u009c\62\3\2\2\2\u009d"+
		"\u009e\7=\2\2\u009e\64\3\2\2\2\u009f\u00a0\7?\2\2\u00a0\66\3\2\2\2\u00a1"+
		"\u00a5\t\4\2\2\u00a2\u00a4\t\5\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a68\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00aa\7\17\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\b\35\2\2\u00ae:\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b1\7\61\2\2\u00b1"+
		"\u00b5\3\2\2\2\u00b2\u00b4\n\6\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00b9\b\36\2\2\u00b9<\3\2\2\2\u00ba\u00bc\t\7\2\2"+
		"\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\37\2\2\u00c0>\3\2\2\2\u00c1"+
		"\u00c2\7\61\2\2\u00c2\u00c3\7,\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6\13"+
		"\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7,"+
		"\2\2\u00cb\u00cc\7\61\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b \2\2\u00ce"+
		"@\3\2\2\2\13\2pt\177\u00a5\u00a9\u00b5\u00bd\u00c7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}