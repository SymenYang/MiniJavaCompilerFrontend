// Generated from MiniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, IntergerLiteral=36, Identifier=37, 
		WS=38, Comment=39, LineComment=40;
	public static final int
		RULE_goal = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_type = 5, RULE_expression = 6, RULE_expression2 = 7, 
		RULE_statement = 8;
	public static final String[] ruleNames = {
		"goal", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"type", "expression", "expression2", "statement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'('", 
		"'String'", "'['", "']'", "')'", "'}'", "'extends'", "';'", "','", "'return'", 
		"'int'", "'boolean'", "'true'", "'false'", "'this'", "'new'", "'!'", "'.'", 
		"'length'", "'&&'", "'<'", "'+'", "'-'", "'*'", "'if'", "'else'", "'while'", 
		"'System.out.println'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"IntergerLiteral", "Identifier", "WS", "Comment", "LineComment"
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

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GoalContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitGoal(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			mainClass();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(19);
				classDeclaration();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MiniJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MiniJavaParser.Identifier, i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMainClass(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(T__0);
			setState(26);
			match(Identifier);
			setState(27);
			match(T__1);
			setState(28);
			match(T__2);
			setState(29);
			match(T__3);
			setState(30);
			match(T__4);
			setState(31);
			match(T__5);
			setState(32);
			match(T__6);
			setState(33);
			match(T__7);
			setState(34);
			match(T__8);
			setState(35);
			match(T__9);
			setState(36);
			match(Identifier);
			setState(37);
			match(T__10);
			setState(38);
			match(T__1);
			setState(39);
			statement();
			setState(40);
			match(T__11);
			setState(41);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MiniJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MiniJavaParser.Identifier, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			match(Identifier);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(45);
				match(T__12);
				setState(46);
				match(Identifier);
				}
			}

			setState(49);
			match(T__1);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << Identifier))) != 0)) {
				{
				{
				setState(50);
				varDeclaration();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(56);
				methodDeclaration();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			type();
			setState(65);
			match(Identifier);
			setState(66);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MiniJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MiniJavaParser.Identifier, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__2);
			setState(69);
			type();
			setState(70);
			match(Identifier);
			setState(71);
			match(T__6);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << Identifier))) != 0)) {
				{
				setState(72);
				type();
				setState(73);
				match(Identifier);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(74);
					match(T__14);
					setState(75);
					type();
					setState(76);
					match(Identifier);
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(85);
			match(T__10);
			setState(86);
			match(T__1);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					varDeclaration();
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << Identifier))) != 0)) {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__15);
			setState(100);
			expression();
			setState(101);
			match(T__13);
			setState(102);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__16);
				setState(105);
				match(T__8);
				setState(106);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__17);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(T__16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public TerminalNode IntergerLiteral() { return getToken(MiniJavaParser.IntergerLiteral, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T__18);
				setState(113);
				expression2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(T__19);
				setState(115);
				expression2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(IntergerLiteral);
				setState(117);
				expression2();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(Identifier);
				setState(119);
				expression2();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(T__20);
				setState(121);
				expression2();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(T__21);
				setState(123);
				match(T__16);
				setState(124);
				match(T__8);
				setState(125);
				expression();
				setState(126);
				match(T__9);
				setState(127);
				expression2();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				match(T__21);
				setState(130);
				match(Identifier);
				setState(131);
				match(T__6);
				setState(132);
				match(T__10);
				setState(133);
				expression2();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				match(T__22);
				setState(135);
				expression();
				setState(136);
				expression2();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(138);
				match(T__6);
				setState(139);
				expression();
				setState(140);
				match(T__10);
				setState(141);
				expression2();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression2Context extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public Expression2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpression2(this);
		}
	}

	public final Expression2Context expression2() throws RecognitionException {
		Expression2Context _localctx = new Expression2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression2);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(T__8);
				setState(146);
				expression();
				setState(147);
				match(T__9);
				setState(148);
				expression2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__23);
				setState(151);
				match(T__24);
				setState(152);
				expression2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(T__23);
				setState(154);
				match(Identifier);
				setState(155);
				match(T__6);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << IntergerLiteral) | (1L << Identifier))) != 0)) {
					{
					setState(156);
					expression();
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(157);
						match(T__14);
						setState(158);
						expression();
						}
						}
						setState(163);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(166);
				match(T__10);
				setState(167);
				expression2();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(169);
				expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(T__1);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << Identifier))) != 0)) {
					{
					{
					setState(174);
					statement();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(180);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(T__30);
				setState(182);
				match(T__6);
				setState(183);
				expression();
				setState(184);
				match(T__10);
				setState(185);
				statement();
				setState(186);
				match(T__31);
				setState(187);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				match(T__32);
				setState(190);
				match(T__6);
				setState(191);
				expression();
				setState(192);
				match(T__10);
				setState(193);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(T__33);
				setState(196);
				match(T__6);
				setState(197);
				expression();
				setState(198);
				match(T__10);
				setState(199);
				match(T__13);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(Identifier);
				setState(202);
				match(T__34);
				setState(203);
				expression();
				setState(204);
				match(T__13);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				match(Identifier);
				setState(207);
				match(T__8);
				setState(208);
				expression();
				setState(209);
				match(T__9);
				setState(210);
				match(T__34);
				setState(211);
				expression();
				setState(212);
				match(T__13);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\7\4"+
		"\66\n\4\f\4\16\49\13\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6Q\n\6\f\6\16\6T\13\6\5"+
		"\6V\n\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\6\7\6a\n\6\f\6\16\6d\13"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0092\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a2\n\t\f\t\16\t\u00a5"+
		"\13\t\5\t\u00a7\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ae\n\t\3\n\3\n\7\n\u00b2"+
		"\n\n\f\n\16\n\u00b5\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00d9\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3"+
		"\3\2\34 \2\u00f0\2\24\3\2\2\2\4\33\3\2\2\2\6-\3\2\2\2\bB\3\2\2\2\nF\3"+
		"\2\2\2\fp\3\2\2\2\16\u0091\3\2\2\2\20\u00ad\3\2\2\2\22\u00d8\3\2\2\2\24"+
		"\30\5\4\3\2\25\27\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30"+
		"\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33\34\7\3\2\2\34\35\7\'\2\2\35"+
		"\36\7\4\2\2\36\37\7\5\2\2\37 \7\6\2\2 !\7\7\2\2!\"\7\b\2\2\"#\7\t\2\2"+
		"#$\7\n\2\2$%\7\13\2\2%&\7\f\2\2&\'\7\'\2\2\'(\7\r\2\2()\7\4\2\2)*\5\22"+
		"\n\2*+\7\16\2\2+,\7\16\2\2,\5\3\2\2\2-.\7\3\2\2.\61\7\'\2\2/\60\7\17\2"+
		"\2\60\62\7\'\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\67\7\4\2\2"+
		"\64\66\5\b\5\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28=\3"+
		"\2\2\29\67\3\2\2\2:<\5\n\6\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>"+
		"@\3\2\2\2?=\3\2\2\2@A\7\16\2\2A\7\3\2\2\2BC\5\f\7\2CD\7\'\2\2DE\7\20\2"+
		"\2E\t\3\2\2\2FG\7\5\2\2GH\5\f\7\2HI\7\'\2\2IU\7\t\2\2JK\5\f\7\2KR\7\'"+
		"\2\2LM\7\21\2\2MN\5\f\7\2NO\7\'\2\2OQ\3\2\2\2PL\3\2\2\2QT\3\2\2\2RP\3"+
		"\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3\2\2\2UJ\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7"+
		"\r\2\2X\\\7\4\2\2Y[\5\b\5\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2"+
		"]b\3\2\2\2^\\\3\2\2\2_a\5\22\n\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2"+
		"\2ce\3\2\2\2db\3\2\2\2ef\7\22\2\2fg\5\16\b\2gh\7\20\2\2hi\7\16\2\2i\13"+
		"\3\2\2\2jk\7\23\2\2kl\7\13\2\2lq\7\f\2\2mq\7\24\2\2nq\7\23\2\2oq\7\'\2"+
		"\2pj\3\2\2\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2q\r\3\2\2\2rs\7\25\2\2s\u0092"+
		"\5\20\t\2tu\7\26\2\2u\u0092\5\20\t\2vw\7&\2\2w\u0092\5\20\t\2xy\7\'\2"+
		"\2y\u0092\5\20\t\2z{\7\27\2\2{\u0092\5\20\t\2|}\7\30\2\2}~\7\23\2\2~\177"+
		"\7\13\2\2\177\u0080\5\16\b\2\u0080\u0081\7\f\2\2\u0081\u0082\5\20\t\2"+
		"\u0082\u0092\3\2\2\2\u0083\u0084\7\30\2\2\u0084\u0085\7\'\2\2\u0085\u0086"+
		"\7\t\2\2\u0086\u0087\7\r\2\2\u0087\u0092\5\20\t\2\u0088\u0089\7\31\2\2"+
		"\u0089\u008a\5\16\b\2\u008a\u008b\5\20\t\2\u008b\u0092\3\2\2\2\u008c\u008d"+
		"\7\t\2\2\u008d\u008e\5\16\b\2\u008e\u008f\7\r\2\2\u008f\u0090\5\20\t\2"+
		"\u0090\u0092\3\2\2\2\u0091r\3\2\2\2\u0091t\3\2\2\2\u0091v\3\2\2\2\u0091"+
		"x\3\2\2\2\u0091z\3\2\2\2\u0091|\3\2\2\2\u0091\u0083\3\2\2\2\u0091\u0088"+
		"\3\2\2\2\u0091\u008c\3\2\2\2\u0092\17\3\2\2\2\u0093\u0094\7\13\2\2\u0094"+
		"\u0095\5\16\b\2\u0095\u0096\7\f\2\2\u0096\u0097\5\20\t\2\u0097\u00ae\3"+
		"\2\2\2\u0098\u0099\7\32\2\2\u0099\u009a\7\33\2\2\u009a\u00ae\5\20\t\2"+
		"\u009b\u009c\7\32\2\2\u009c\u009d\7\'\2\2\u009d\u00a6\7\t\2\2\u009e\u00a3"+
		"\5\16\b\2\u009f\u00a0\7\21\2\2\u00a0\u00a2\5\16\b\2\u00a1\u009f\3\2\2"+
		"\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\7\r\2\2\u00a9\u00ae\5\20\t\2\u00aa\u00ab\t"+
		"\2\2\2\u00ab\u00ae\5\16\b\2\u00ac\u00ae\3\2\2\2\u00ad\u0093\3\2\2\2\u00ad"+
		"\u0098\3\2\2\2\u00ad\u009b\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ac\3\2"+
		"\2\2\u00ae\21\3\2\2\2\u00af\u00b3\7\4\2\2\u00b0\u00b2\5\22\n\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00d9\7\16\2\2\u00b7\u00b8\7"+
		"!\2\2\u00b8\u00b9\7\t\2\2\u00b9\u00ba\5\16\b\2\u00ba\u00bb\7\r\2\2\u00bb"+
		"\u00bc\5\22\n\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\5\22\n\2\u00be\u00d9\3"+
		"\2\2\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\5\16\b\2\u00c2"+
		"\u00c3\7\r\2\2\u00c3\u00c4\5\22\n\2\u00c4\u00d9\3\2\2\2\u00c5\u00c6\7"+
		"$\2\2\u00c6\u00c7\7\t\2\2\u00c7\u00c8\5\16\b\2\u00c8\u00c9\7\r\2\2\u00c9"+
		"\u00ca\7\20\2\2\u00ca\u00d9\3\2\2\2\u00cb\u00cc\7\'\2\2\u00cc\u00cd\7"+
		"%\2\2\u00cd\u00ce\5\16\b\2\u00ce\u00cf\7\20\2\2\u00cf\u00d9\3\2\2\2\u00d0"+
		"\u00d1\7\'\2\2\u00d1\u00d2\7\13\2\2\u00d2\u00d3\5\16\b\2\u00d3\u00d4\7"+
		"\f\2\2\u00d4\u00d5\7%\2\2\u00d5\u00d6\5\16\b\2\u00d6\u00d7\7\20\2\2\u00d7"+
		"\u00d9\3\2\2\2\u00d8\u00af\3\2\2\2\u00d8\u00b7\3\2\2\2\u00d8\u00bf\3\2"+
		"\2\2\u00d8\u00c5\3\2\2\2\u00d8\u00cb\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d9"+
		"\23\3\2\2\2\21\30\61\67=RU\\bp\u0091\u00a3\u00a6\u00ad\u00b3\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}