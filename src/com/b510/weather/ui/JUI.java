/**
 * 
 */
package com.b510.weather.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;
import org.jvnet.substance.skin.ChallengerDeepSkin;
import org.jvnet.substance.skin.CremeCoffeeSkin;
import org.jvnet.substance.skin.CremeSkin;
import org.jvnet.substance.skin.EbonyHighContrastSkin;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.FieldOfWheatSkin;
import org.jvnet.substance.skin.FindingNemoSkin;
import org.jvnet.substance.skin.GreenMagicSkin;
import org.jvnet.substance.skin.MagmaSkin;
import org.jvnet.substance.skin.MangoSkin;
import org.jvnet.substance.skin.MistSilverSkin;
import org.jvnet.substance.skin.ModerateSkin;
import org.jvnet.substance.skin.NebulaBrickWallSkin;
import org.jvnet.substance.skin.NebulaSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.skin.RavenGraphiteGlassSkin;
import org.jvnet.substance.skin.RavenGraphiteSkin;
import org.jvnet.substance.skin.RavenSkin;
import org.jvnet.substance.skin.SaharaSkin;
import org.jvnet.substance.skin.SubstanceAbstractSkin;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.theme.SubstanceTheme;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;
import org.jvnet.substance.watermark.SubstanceWatermark;

/**
 * @author Hongten
 * @created 6 Mar, 2016
 */
public class JUI extends JFrame {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(JUI.class);

	static SubstanceTheme theme;
	static SubstanceAbstractSkin skin;
	static int skinNum = 17;
	static SubstanceWatermark watermark;
	String title;

	public SubstanceTheme getTheme() {
		return new SubstanceAquaTheme();
	}

	/**
	 * Total skins : 21. Get the skin according to the <code>skinNums</code>
	 * value
	 * 
	 * @param num <code>skinNum</code> value
	 * @return
	 */
	public SubstanceAbstractSkin getSkin(int num) {
		logger.debug("skinNum = " + num);
		switch (num) {
		case 1:
			skin = new AutumnSkin();
			break;
		case 2:
			skin = new BusinessBlackSteelSkin();
			break;
		case 3:
			skin = new ChallengerDeepSkin();
			break;
		case 4:
			skin = new CremeCoffeeSkin();
			break;
		case 5:
			skin = new CremeSkin();
			break;
		case 6:
			skin = new EbonyHighContrastSkin();
			break;
		case 7:
			skin = new EmeraldDuskSkin();
			break;
		case 8:
			skin = new FieldOfWheatSkin();
			break;
		case 9:
			skin = new FindingNemoSkin();
			break;
		case 10:
			skin = new GreenMagicSkin();
			break;
		case 11:
			skin = new MagmaSkin();
			break;
		case 12:
			skin = new MangoSkin();
			break;
		case 13:
			skin = new MistSilverSkin();
			break;
		case 14:
			skin = new ModerateSkin();
			break;
		case 15:
			skin = new NebulaBrickWallSkin();
			break;
		case 16:
			skin = new NebulaSkin();
			break;
		case 17:
			skin = new OfficeBlue2007Skin();
			break;
		case 18:
			skin = new RavenGraphiteGlassSkin();
			break;
		case 19:
			skin = new RavenGraphiteSkin();
			break;
		case 20:
			skin = new RavenSkin();
			break;
		case 21:
			skin = new SaharaSkin();
			break;
		default:
			skin = new FieldOfWheatSkin();
			break;
		}
		return skin;
	}

	public SubstanceWatermark getWatermark() {
		return new SubstanceBubblesWatermark();
	}

	/**
	 * Set the page UI. including the theme, skin, watermark.etc.
	 */
	public void setJUI() {
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setCurrentTheme(getTheme());
			SubstanceLookAndFeel.setSkin(getSkin(skinNum));
			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
			SubstanceLookAndFeel.setCurrentWatermark(getWatermark());
			SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
			SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}

	public JUI(String title) {
		this.title = title;
		setJUI();
	}

	public void init() {

	}
}
