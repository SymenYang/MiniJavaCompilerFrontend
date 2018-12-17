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
		RULE_goal = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_statement = 3, 
		RULE_varDeclaration = 4, RULE_methodDeclaration = 5, RULE_type = 6, RULE_expression = 7, 
		RULE_expression2 = 8;
	public static final String[] ruleNames = {
		"goal", "mainClass", "classDeclaration", "statement", "varDeclaration", 
		"methodDeclaration", "type", "expression", "expression2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'('", 
		"'String'", "'['", "']'", "')'", "'}'", "'extends'", "'if'", "'else'", 
		"'while'", "'System.out.println'", "';'", "'='", "','", "'return'", "'int'", 
		"'boolean'", "'true'", "'false'", "'this'", "'new'", "'!'", "'.'", "'length'", 
		"'&&'", "'<'", "'+'", "'-'", "'*'"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << Identifier))) != 0)) {
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
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__1);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << Identifier))) != 0)) {
					{
					{
					setState(65);
					statement();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__13);
				setState(73);
				match(T__6);
				setState(74);
				expression();
				setState(75);
				match(T__10);
				setState(76);
				statement();
				setState(77);
				match(T__14);
				setState(78);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(T__15);
				setState(81);
				match(T__6);
				setState(82);
				expression();
				setState(83);
				match(T__10);
				setState(84);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(T__16);
				setState(87);
				match(T__6);
				setState(88);
				expression();
				setState(89);
				match(T__10);
				setState(90);
				match(T__17);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(Identifier);
				setState(93);
				match(T__18);
				setState(94);
				expression();
				setState(95);
				match(T__17);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
				match(Identifier);
				setState(98);
				match(T__8);
				setState(99);
				expression();
				setState(100);
				match(T__9);
				setState(101);
				match(T__18);
				setState(102);
				expression();
				setState(103);
				match(T__17);
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
		enterRule(_localctx, 8, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			type();
			setState(108);
			match(Identifier);
			setState(109);
			match(T__17);
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
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__2);
			setState(112);
			type();
			setState(113);
			match(Identifier);
			setState(114);
			match(T__6);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << Identifier))) != 0)) {
				{
				setState(115);
				type();
				setState(116);
				match(Identifier);
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(117);
					match(T__19);
					setState(118);
					type();
					setState(119);
					match(Identifier);
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(128);
			match(T__10);
			setState(129);
			match(T__1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					varDeclaration();
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << Identifier))) != 0)) {
				{
				{
				setState(136);
				statement();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__20);
			setState(143);
			expression();
			setState(144);
			match(T__17);
			setState(145);
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
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__21);
				setState(148);
				match(T__8);
				setState(149);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__22);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(T__21);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
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
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__23);
				setState(156);
				expression2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(T__24);
				setState(158);
				expression2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(Identifier);
				setState(160);
				expression2();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				match(T__25);
				setState(162);
				expression2();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				match(T__26);
				setState(164);
				match(T__21);
				setState(165);
				match(T__8);
				setState(166);
				expression();
				setState(167);
				match(T__9);
				setState(168);
				expression2();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(T__26);
				setState(171);
				match(Identifier);
				setState(172);
				match(T__6);
				setState(173);
				match(T__10);
				setState(174);
				expression2();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(175);
				match(T__27);
				setState(176);
				expression();
				setState(177);
				expression2();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				match(T__6);
				setState(180);
				expression();
				setState(181);
				match(T__10);
				setState(182);
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
		enterRule(_localctx, 16, RULE_expression2);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__8);
				setState(187);
				expression();
				setState(188);
				match(T__9);
				setState(189);
				expression2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(T__28);
				setState(192);
				match(T__29);
				setState(193);
				expression2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(T__28);
				setState(195);
				match(Identifier);
				setState(196);
				match(T__6);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << Identifier))) != 0)) {
					{
					setState(197);
					expression();
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__19) {
						{
						{
						setState(198);
						match(T__19);
						setState(199);
						expression();
						}
						}
						setState(204);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(207);
				match(T__10);
				setState(208);
				expression2();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				expression();
				setState(211);
				expression2();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\7\4"+
		"\66\n\4\f\4\16\49\13\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5\3\5\7\5"+
		"E\n\5\f\5\16\5H\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5l\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7|\n\7\f\7\16\7\177\13\7\5\7\u0081\n\7\3\7\3\7\3\7\7\7"+
		"\u0086\n\7\f\7\16\7\u0089\13\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f\13\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009c\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00bb\n\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00cb\n\n\f\n\16\n\u00ce\13\n\5\n"+
		"\u00d0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d9\n\n\3\n\2\2\13\2\4\6"+
		"\b\n\f\16\20\22\2\3\3\2!%\2\u00ef\2\24\3\2\2\2\4\33\3\2\2\2\6-\3\2\2\2"+
		"\bk\3\2\2\2\nm\3\2\2\2\fq\3\2\2\2\16\u009b\3\2\2\2\20\u00ba\3\2\2\2\22"+
		"\u00d8\3\2\2\2\24\30\5\4\3\2\25\27\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2"+
		"\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33\34\7\3\2\2"+
		"\34\35\7\'\2\2\35\36\7\4\2\2\36\37\7\5\2\2\37 \7\6\2\2 !\7\7\2\2!\"\7"+
		"\b\2\2\"#\7\t\2\2#$\7\n\2\2$%\7\13\2\2%&\7\f\2\2&\'\7\'\2\2\'(\7\r\2\2"+
		"()\7\4\2\2)*\5\b\5\2*+\7\16\2\2+,\7\16\2\2,\5\3\2\2\2-.\7\3\2\2.\61\7"+
		"\'\2\2/\60\7\17\2\2\60\62\7\'\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2"+
		"\2\2\63\67\7\4\2\2\64\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28=\3\2\2\29\67\3\2\2\2:<\5\f\7\2;:\3\2\2\2<?\3\2\2\2=;\3"+
		"\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\16\2\2A\7\3\2\2\2BF\7\4\2\2C"+
		"E\5\b\5\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2"+
		"Il\7\16\2\2JK\7\20\2\2KL\7\t\2\2LM\5\20\t\2MN\7\r\2\2NO\5\b\5\2OP\7\21"+
		"\2\2PQ\5\b\5\2Ql\3\2\2\2RS\7\22\2\2ST\7\t\2\2TU\5\20\t\2UV\7\r\2\2VW\5"+
		"\b\5\2Wl\3\2\2\2XY\7\23\2\2YZ\7\t\2\2Z[\5\20\t\2[\\\7\r\2\2\\]\7\24\2"+
		"\2]l\3\2\2\2^_\7\'\2\2_`\7\25\2\2`a\5\20\t\2ab\7\24\2\2bl\3\2\2\2cd\7"+
		"\'\2\2de\7\13\2\2ef\5\20\t\2fg\7\f\2\2gh\7\25\2\2hi\5\20\t\2ij\7\24\2"+
		"\2jl\3\2\2\2kB\3\2\2\2kJ\3\2\2\2kR\3\2\2\2kX\3\2\2\2k^\3\2\2\2kc\3\2\2"+
		"\2l\t\3\2\2\2mn\5\16\b\2no\7\'\2\2op\7\24\2\2p\13\3\2\2\2qr\7\5\2\2rs"+
		"\5\16\b\2st\7\'\2\2t\u0080\7\t\2\2uv\5\16\b\2v}\7\'\2\2wx\7\26\2\2xy\5"+
		"\16\b\2yz\7\'\2\2z|\3\2\2\2{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\u0081\3\2\2\2\177}\3\2\2\2\u0080u\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\7\r\2\2\u0083\u0087\7\4\2\2\u0084\u0086\5\n"+
		"\6\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008d\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\b"+
		"\5\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\27"+
		"\2\2\u0091\u0092\5\20\t\2\u0092\u0093\7\24\2\2\u0093\u0094\7\16\2\2\u0094"+
		"\r\3\2\2\2\u0095\u0096\7\30\2\2\u0096\u0097\7\13\2\2\u0097\u009c\7\f\2"+
		"\2\u0098\u009c\7\31\2\2\u0099\u009c\7\30\2\2\u009a\u009c\7\'\2\2\u009b"+
		"\u0095\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2"+
		"\2\2\u009c\17\3\2\2\2\u009d\u009e\7\32\2\2\u009e\u00bb\5\22\n\2\u009f"+
		"\u00a0\7\33\2\2\u00a0\u00bb\5\22\n\2\u00a1\u00a2\7\'\2\2\u00a2\u00bb\5"+
		"\22\n\2\u00a3\u00a4\7\34\2\2\u00a4\u00bb\5\22\n\2\u00a5\u00a6\7\35\2\2"+
		"\u00a6\u00a7\7\30\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9\5\20\t\2\u00a9"+
		"\u00aa\7\f\2\2\u00aa\u00ab\5\22\n\2\u00ab\u00bb\3\2\2\2\u00ac\u00ad\7"+
		"\35\2\2\u00ad\u00ae\7\'\2\2\u00ae\u00af\7\t\2\2\u00af\u00b0\7\r\2\2\u00b0"+
		"\u00bb\5\22\n\2\u00b1\u00b2\7\36\2\2\u00b2\u00b3\5\20\t\2\u00b3\u00b4"+
		"\5\22\n\2\u00b4\u00bb\3\2\2\2\u00b5\u00b6\7\t\2\2\u00b6\u00b7\5\20\t\2"+
		"\u00b7\u00b8\7\r\2\2\u00b8\u00b9\5\22\n\2\u00b9\u00bb\3\2\2\2\u00ba\u009d"+
		"\3\2\2\2\u00ba\u009f\3\2\2\2\u00ba\u00a1\3\2\2\2\u00ba\u00a3\3\2\2\2\u00ba"+
		"\u00a5\3\2\2\2\u00ba\u00ac\3\2\2\2\u00ba\u00b1\3\2\2\2\u00ba\u00b5\3\2"+
		"\2\2\u00bb\21\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00be\5\20\t\2\u00be"+
		"\u00bf\7\f\2\2\u00bf\u00c0\5\22\n\2\u00c0\u00d9\3\2\2\2\u00c1\u00c2\7"+
		"\37\2\2\u00c2\u00c3\7 \2\2\u00c3\u00d9\5\22\n\2\u00c4\u00c5\7\37\2\2\u00c5"+
		"\u00c6\7\'\2\2\u00c6\u00cf\7\t\2\2\u00c7\u00cc\5\20\t\2\u00c8\u00c9\7"+
		"\26\2\2\u00c9\u00cb\5\20\t\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\7\r\2\2\u00d2\u00d9\5\22\n\2\u00d3\u00d4\t\2\2\2\u00d4\u00d5\5"+
		"\20\t\2\u00d5\u00d6\5\22\n\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00bc\3\2\2\2\u00d8\u00c1\3\2\2\2\u00d8\u00c4\3\2\2\2\u00d8\u00d3\3\2"+
		"\2\2\u00d8\u00d7\3\2\2\2\u00d9\23\3\2\2\2\21\30\61\67=Fk}\u0080\u0087"+
		"\u008d\u009b\u00ba\u00cc\u00cf\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}