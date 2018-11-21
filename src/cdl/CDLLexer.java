// Generated from CDL.g4 by ANTLR 4.7.1

    package cdl;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CDLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ID=17, 
		NUMBER=18, COMMENT=19, WHITE_SPACE=20, WRONG_CHAR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "LETTER", 
		"DIGIT", "ID", "NUMBER", "COMMENT", "WHITE_SPACE", "WRONG_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'circuit'", "'('", "')'", "':'", "'{'", "'}'", "','", "'='", "'new'", 
		"'|'", "'^'", "'&'", "'~'", "'true'", "'false'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "ID", "NUMBER", "COMMENT", "WHITE_SPACE", 
		"WRONG_CHAR"
	};
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


	public CDLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CDL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\5\24g\n\24\3\24\3\24\3\24\7\24l\n\24\f\24\16\24o"+
		"\13\24\3\25\6\25r\n\25\r\25\16\25s\3\26\3\26\3\26\3\26\7\26z\n\26\f\26"+
		"\16\26}\13\26\3\26\3\26\3\26\3\26\7\26\u0083\n\26\f\26\16\26\u0086\13"+
		"\26\3\26\3\26\5\26\u008a\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\u0084\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\2%\2\'\23)\24+\25-\26/\27\3\2\5\4\2C\\c|\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"\2\u0098\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\3\61\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2"+
		"\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27M\3"+
		"\2\2\2\31O\3\2\2\2\33Q\3\2\2\2\35S\3\2\2\2\37X\3\2\2\2!^\3\2\2\2#`\3\2"+
		"\2\2%b\3\2\2\2\'f\3\2\2\2)q\3\2\2\2+\u0089\3\2\2\2-\u008d\3\2\2\2/\u0091"+
		"\3\2\2\2\61\62\7e\2\2\62\63\7k\2\2\63\64\7t\2\2\64\65\7e\2\2\65\66\7w"+
		"\2\2\66\67\7k\2\2\678\7v\2\28\4\3\2\2\29:\7*\2\2:\6\3\2\2\2;<\7+\2\2<"+
		"\b\3\2\2\2=>\7<\2\2>\n\3\2\2\2?@\7}\2\2@\f\3\2\2\2AB\7\177\2\2B\16\3\2"+
		"\2\2CD\7.\2\2D\20\3\2\2\2EF\7?\2\2F\22\3\2\2\2GH\7p\2\2HI\7g\2\2IJ\7y"+
		"\2\2J\24\3\2\2\2KL\7~\2\2L\26\3\2\2\2MN\7`\2\2N\30\3\2\2\2OP\7(\2\2P\32"+
		"\3\2\2\2QR\7\u0080\2\2R\34\3\2\2\2ST\7v\2\2TU\7t\2\2UV\7w\2\2VW\7g\2\2"+
		"W\36\3\2\2\2XY\7h\2\2YZ\7c\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2] \3\2\2\2"+
		"^_\7\60\2\2_\"\3\2\2\2`a\t\2\2\2a$\3\2\2\2bc\4\62;\2c&\3\2\2\2dg\5#\22"+
		"\2eg\7a\2\2fd\3\2\2\2fe\3\2\2\2gm\3\2\2\2hl\5#\22\2il\7a\2\2jl\5%\23\2"+
		"kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n(\3\2\2\2"+
		"om\3\2\2\2pr\5%\23\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t*\3\2\2\2"+
		"uv\7\61\2\2vw\7\61\2\2w{\3\2\2\2xz\n\3\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|\u008a\3\2\2\2}{\3\2\2\2~\177\7\61\2\2\177\u0080\7,\2\2\u0080"+
		"\u0084\3\2\2\2\u0081\u0083\13\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0088\7,\2\2\u0088\u008a\7\61\2\2\u0089u\3\2\2\2"+
		"\u0089~\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\26\2\2\u008c,\3\2\2"+
		"\2\u008d\u008e\t\4\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\27\2\2\u0090"+
		".\3\2\2\2\u0091\u0092\13\2\2\2\u0092\60\3\2\2\2\n\2fkms{\u0084\u0089\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}