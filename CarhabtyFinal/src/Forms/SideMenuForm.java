package Forms;

import Entity.MusicGame;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

/**
 * Base class for the forms with common functionality
 *
 * @author Shai Almog
 */
public class SideMenuForm extends Form {

    public SideMenuForm() {
    }

    public SideMenuForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public SideMenuForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {
        Toolbar tb = getToolbar();
        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 6) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 6);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        tb.addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond"))
        ));

        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> { MusicGame.getInstance().stop();new ProfileForm(res).show();});
        tb.addMaterialCommandToSideMenu("Offre", FontImage.MATERIAL_SHOPPING_CART, e -> { MusicGame.getInstance().stop();new OffreForm(res).show();});
        tb.addMaterialCommandToSideMenu("Paiement Partenaire", FontImage.MATERIAL_ACCESSIBILITY, e -> { MusicGame.getInstance().stop();new UnpaidPartnerForm(res).show();});
        tb.addMaterialCommandToSideMenu("Localisation", FontImage.MATERIAL_ACCESSIBILITY, e ->{ MusicGame.getInstance().stop(); new MapForm(res).show();});
       // tb.addMaterialCommandToSideMenu("Partenaire non payé", FontImage.MATERIAL_ACCESSIBILITY, e -> new UnpaidPartnerForm(res).show());
        tb.addMaterialCommandToSideMenu("Voiture", FontImage.MATERIAL_SHOPPING_CART, e -> { MusicGame.getInstance().stop(); new VoitureForm(res).show();});
        tb.addMaterialCommandToSideMenu("Event", FontImage.MATERIAL_EXIT_TO_APP, e -> { MusicGame.getInstance().stop();new LoginForm(res).show();});
        tb.addMaterialCommandToSideMenu("Astuce", FontImage.MATERIAL_EXIT_TO_APP, e -> { MusicGame.getInstance().stop();new LoginForm(res).show();});
        tb.addMaterialCommandToSideMenu("Quiz", FontImage.MATERIAL_EXIT_TO_APP, e -> { MusicGame.getInstance().stop();new QuizForm(res).show();});
        tb.addMaterialCommandToSideMenu("Déconnexion", FontImage.MATERIAL_EXIT_TO_APP, e -> { MusicGame.getInstance().stop();new LoginForm(res).show();});

    }
}
