package cn.ustc.datacenter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.CookieManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.MarshalHashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class ElwsDataCenterApi {
	private static final String SOAP_URL = "http://ustcnet.ustc.edu.cn/dataCenterApi/dcaApi_soap.php";
	private static final String NS_URL = "http://ustcnet.ustc.edu.cn/dataCenterApi/";

	private static final String csIdText = "M'aD!!00KLME(AIlHM}b6%q9~K*UM)nky]y8KG0RbxrC!l;nvdT*jb.V(^&Ye{GOSs8dhKMS'%=Iqqa*c'`Aj;C:Abd-KhJLI!e`PDJ@:hCv:}oA@#Gs-ewqM`Yij[W1?~J~Y).YV5!:wV-P9*h^B%/F0PEZ*Z^}~tT(9%g3m}gT1B#>>7/(bCF!(MAJP8rA}D2(M-AzK,[9uYN~isL't>O9GH8T[Sx9B^_ceQ7F3-KJ&z9J{)0h;n^CcV|%2^F0}|c@s(;<^`|E@[wxs;+]P}L5yVw)xm<bfJE7Hy]v|+9y-cDLe]K,emprmiLfWS}ni/q82g2dQ>8h?BJMI>qd2uzd<9,uSN:7%}=gK4`UZ/j0=MPd>C9q/>kbzKJBPT=V2RLn>rPcwli;JA&p0WtVbS?Ju;4-,8I.d[LH^`lH[2,F^|htnzOKgU%FBsXtM_9/|K<EyQIc#H`vqjKbTkbz}SDK0;n6^XJ6e&;YJtx=J%6Ah=A<?lfNHQDMr<u-2g(PdreC[Y[:?wJ>{s6<6TG&['vB2M)n7xtRLhW,pw^Zpslm[y;X9V~XgR&EU(dQ&83Kb;Vx4dXp';J);_p*1;ZNgN~I1kFApSu.PO2u'}:~G}UfnXkNT=+vT.0RGP5-;'|O]YTr8LR^tI1UiEJsb>*Do0^8J*PbyLcY.7,en;*+<rR!E+TrYlJIxAFua'jL:a:s!C:V?tYy-F01yoc!I]9ui0U>?:->7`J7<P]k`XK,vR@Aq(%C`x@SSkbS}JW!U,<LAyBKXm_+U=`1D:#I?WC^WBU1?KVx{rS5ry<jG(:ob-;b]yf+5{?rruh?uT}8M5+>e!hrJW7Eo{)/xiD`&EM:q[UJPDREHdcB,}}%b:`s:!oG2u@O5qAEL[(m=.-?rY1{?8x2rTC3w1yjuzN<u{>4r`%je9b@~vKS>B[GW?E>o<fYq))@Ss1Wlx]pTjp&x4B`dWgC*~lFn;B(4v:+W9d,`y/+k]ZUblbGW^jCiyWwNj<(.3GOWLJQJ1<b'c8HA6#xBf2V=)`lT9H_1!%oafPkDWCIX).Y=>7.QKz{'o0H4R~pX6/J!sB,[E;yr:cAp;3!J{rWt:iu,#C6LLXq/]!n?{UwKGqI7HeZn[VyGD@.2Zl@UY%ABuiEn4Nm(tAmv~!(EWsfB=Yx;+7syL>k|D7q6,R%#dC*/);thq6WsC`K0c<q&9:`Ri.DP@=',le1ToN;fTDJ^hCbNj0+;xXz[F/Hb:QCGlMfe7;`*1mc^G')!Az+R&6U#[|Q4-35Ox%?eY'31+'Dg-PE4.~kKKe(i/=zTHyn7GO=,AMx1*Nkk{eOZwtx)'LB[src!>b@U|Jo<-p;r7N->@w&8`inWZNX&;:Yu@~zY=Y>],MrV6b8L!k8kf%A;C9+J#Vcpe/iWM`HN(%,|5(u5ucD{1)0XG5,rXOv|9jG5XCQw|Og,il2IY4:Win{;7=cei/kBXRO9.!YxRkl[xzC~a!_IL_-X}pzdvl.(6ZO8nhoN[-tfSzkE&iobOX::`K~l47j1gE9o:r)k(pk(!1Km?WFcgT7-=7i^rUy-]nq`sdK.Ow-Z%!/8S|4Q/O+[[u?#QL7!)[PrJad%@]+]7l-nSE=A2d{oa5E=H|]@58wRONYL3f{{I@G@.py#MjD@!]AotI5j1|,P[)j{>(YrUDq'us;dw5]{7cl:3H^9mjb9I;I>Wo9{T+IC7]>>]llUZXy?D4~w:j5~Y^o*}s?2N9?+ALBtr*t8n:>l!/OAK6d+M&hkF3jv7q8[UIo5?9hF3BcNiG!B=]TEHu!<;-BhCtYw]/1fJ9mSWPUvL4F=vNO7GrPmS9diivFX#U+eB(OpL:>A:@Ud}6j[/OPkTQM.a?C,acu1bhfvLCkH39Fx0I+6X3aEeUQV[B=7=_U3}:2~nUgtw7H1N/kVXawj]>=4v1TtP*b5E(v~OsY}&)fR6?2dA}#VT0.')Q4(3`!BdDaY~LdZ4L!vwr!G}bNT8kE;_>:b2vmO'3|{yv1w=60/kvtkoT~//_KVTtda[zcjt8.'rxOHFiH_*?rzm8a|>^3RB6~D<,#GE76gC)n&_ihfS75r~=vmyu?685oFK:hohO'&AskBm`(4+#|E9/7'Iwm@t@`7J9~RQ*WeG6I/kgMz4dH3gBHgkmss}X#I8?qg`J:l+B.~lVe7a=te`']w^``<N<}4[tZ[taPvc)DPVVl%~9vm|F&G]9@!Ii:g:-%;mL*h)JL-*CG*JN@K9Vv+T9.UZQU:Lyqb6R=V3[/R1HLZMPx";
	private static final String DEFAULT_LOGINNAME = "xxxysyzx";
	private static HeaderProperty mSessionHeader = null;
	public static ElwsDataCenterApi instance = new ElwsDataCenterApi();

	private ElwsDataCenterApi() {

	}

	public static ElwsDataCenterApi getInstance() {
		if (instance == null) {
			instance = new ElwsDataCenterApi();
		}
		return instance;
	}

	/*
	 * 科大数据中心webservice接口
	 */
	public void wsCsLogout() {
		String result = (String) coreCallResponse("wsCsLogout", null);
		// System.err.println("wsCsLogout is " + result);

	}

	public List<UserInfo> wsQueryYktByUserCode(String userCode) {

		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] { "userCode", userCode });

		Object result = coreCallResponse("wsQueryYktByUserCode", params);
		System.err.println("wsQueryYktByUserCode is " + result);
		
		if(result==null){
			System.err.println("数据未找到");
			return null;
		}

		return parseSoapObject(result);

	}

	public List<UserInfo> queryUserInfos(String[] userCodes) {
		/*
		 * 字符集设置
		 */
		wsClientSetCharset();

		String csLoginText = wsClientCreateLoginIdText(DEFAULT_LOGINNAME);

		wsCsLogin(DEFAULT_LOGINNAME, csLoginText);

		if (wsCsCheckLogin()) {
			return ElwsDataCenterApi.getInstance().wsQueryYktByUserCodeArray(
					userCodes);
		}
		return null;

	}

	public List<UserInfo> queryUserInfo(String userCode) {
		/*
		 * 字符集设置
		 */
		wsClientSetCharset();

		String csLoginText = wsClientCreateLoginIdText(DEFAULT_LOGINNAME);

		wsCsLogin(DEFAULT_LOGINNAME, csLoginText);

		if (wsCsCheckLogin()) {
			return ElwsDataCenterApi.getInstance().wsQueryYktByUserCode(
					userCode);

		}
		return null;

	}

	private List<UserInfo> parseVector(Vector<SoapObject> result) {
		List<UserInfo> users = new ArrayList<UserInfo>();
		Class clazz = SoapObject.class;
		Class uClazz = UserInfo.class;

		for (SoapObject so : (Vector<SoapObject>) result) {
			UserInfo user = new UserInfo();
			for (Field fld : clazz.getDeclaredFields()) {
				if (fld.getName().equals("properties")) {
					fld.setAccessible(true);
					Vector<PropertyInfo> ve;
					try {
						ve = (Vector<PropertyInfo>) fld.get(so);
						for (PropertyInfo pi : ve) {
		
							Field uField = uClazz.getField(pi.getName()
									.toLowerCase());
							uField.setAccessible(true);
							uField.set(user, pi.getValue());

						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			users.add(user);
		}

		return users;
	}

	private List<UserInfo> parseSoapObject(Object result) {
		if (result.getClass() == Vector.class) {
			return parseVector((Vector<SoapObject>) result);
		} else {
			SoapObject so = (SoapObject) result;
			Class clazz = SoapObject.class;
			for (Field fld : clazz.getDeclaredFields()) {
				if (fld.getName().equals("properties")) {
					fld.setAccessible(true);
					Vector<PropertyInfo> ve;
					try {
						ve = (Vector<PropertyInfo>) fld.get(so);
						return parseVector((Vector<SoapObject>) ve.get(0)
								.getValue());

					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}


		}
		return null;

	}



	public List<UserInfo> wsQueryYktByUserCodeArray(String[] userCodeArray) {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(userCodeArray);
		Object result = coreCallResponse("wsQueryYktByUserCodeArray", params);
		if(result==null){
			System.err.println("数据未找到");
			return null;
		}
		return parseSoapObject(result);
	}

	public boolean wsCsCheckLogin() {
		String result = (String) coreCallResponse("wsCsCheckLogin", null);

		if ("1".equals(result)) {
			// System.out.println("验证成功");
			return true;
		} else {
			// System.out.println("验证失败");
			return false;
		}
	}

	public boolean wsCsLogin(String csLoginName, String csLoginText) {
		List<Object[]> params = new ArrayList<Object[]>();

		params.add(new Object[] { "csLogin", csLoginName });
		params.add(new Object[] { "csLoginIdText", csLoginText });
		String longStr = csIdText + csLoginText;

		String csToken = MD5Generator.getMD5Value(longStr);

		params.add(new String[] { "csToken", csToken });

		String result = (String) coreCallResponse("wsCsLogin", params);

		if ("1".equals(result)) {
			// System.out.println("登录成功");
			return true;
		} else {
			// System.out.println("登录失败");
			return false;
		}

	}

	/*
	 * 向服务器申请登录标识
	 */
	public String wsClientCreateLoginIdText(String csLoginName) {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] { "csLogin", csLoginName });

		String result = (String) coreCallResponse("wsClientCreateLoginIdText",
				params);
		// System.err.println("wsClientCreateLoginIdText is " + result);

		return result;

	}

	/*
	 * 字符集的设置
	 */
	public void wsClientSetCharset() {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] { "charset", "utf-8" });
		params.add(new Object[] { "xmlCharset", "utf-8" });
		String result = (String) coreCallResponse("wsClientSetCharset", params);
		// System.err.println("wsClientSetCharset is " + result);

	}

	/**
	 * Axis访问wsdl
	 */

	private Object coreCallResponse(String methodName, List<Object[]> params) {

		Object result = null;// 方法的返回值
		String SOAP_ACTION = NS_URL + methodName;
		SoapObject requestObject = new SoapObject(NS_URL, methodName);
		if (params != null) {
			if (methodName.equals("wsQueryYktByUserCodeArray")) {
				for (Object[] oArr : params) {
					for (Object o : oArr) {
						PropertyInfo p = new PropertyInfo();
						p.setName("string");
						p.setValue(o);
						requestObject.addProperty(p);
					}
				}

			} else {
				for (Object[] kv : params) {
					requestObject.addProperty(kv[0].toString(), kv[1]);
				}
			}
		}
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.bodyOut = requestObject;
		HttpTransportSE hts = new HttpTransportSE(SOAP_URL);
		Object o = null;
		try {
			LinkedList<HeaderProperty> reqHeaders = new LinkedList<HeaderProperty>();
			// 若已经带有cookie,则每次访问WebService时,要带有这个cookie。
			if (mSessionHeader != null) {
				reqHeaders.add(new HeaderProperty("Cookie", mSessionHeader
						.getValue()));

			}
			@SuppressWarnings("rawtypes")
			List headerList = hts.call(SOAP_ACTION, envelope, reqHeaders);// 访问WebService
			if (headerList != null) {
				for (Object headerElement : headerList) {
					HeaderProperty headerProperty = (HeaderProperty) headerElement;
					String headerKey = headerProperty.getKey();
					String headerValue = headerProperty.getValue();
					if (headerKey != null
							&& headerKey.equalsIgnoreCase("set-cookie")) {
						// 服务端发送过来的set-cookie项
						mSessionHeader = headerProperty;
					}
				}

			}

			result = envelope.getResponse();

		} catch (SoapFault e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}

		return result;
	}

}
