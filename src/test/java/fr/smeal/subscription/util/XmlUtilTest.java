package fr.smeal.subscription.util;

import org.junit.Test;

public class XmlUtilTest {
    @Test
    public void getValueTest() {
        String xml = "<customer>\n" +
                "    <id>1647</id>\n" +
                "    <id_default_group xlink:href=\"https://www.smeal.fr/api/groups/3\">3</id_default_group>\n" +
                "    <id_lang xlink:href=\"https://www.smeal.fr/api/languages/1\">1</id_lang>\n" +
                "    <newsletter_date_add>0000-00-00 00:00:00</newsletter_date_add>\n" +
                "    <ip_registration_newsletter></ip_registration_newsletter>\n" +
                "    <last_passwd_gen>2018-10-24 19:09:51</last_passwd_gen>\n" +
                "    <secure_key>0262ac59c6bc4378bf9c929f8e0cf59d</secure_key>\n" +
                "    <deleted>0</deleted>\n" +
                "    <passwd>$2y$10$Gk6T1V5J.sBEqjgyj4EXPeWgbpcqhn1tg6X3be8N09r.BSQvPfsBi</passwd>\n" +
                "    <lastname>WANG</lastname>\n" +
                "    <firstname>Yang</firstname>\n" +
                "    <email>yangpub@yahoo.fr</email>\n" +
                "    <id_gender>1</id_gender>\n" +
                "    <birthday>2011-11-11</birthday>\n" +
                "    <newsletter>0</newsletter>\n" +
                "    <optin>0</optin>\n" +
                "    <website></website>\n" +
                "    <company></company>\n" +
                "    <siret></siret>\n" +
                "    <ape></ape>\n" +
                "    <outstanding_allow_amount>0.000000</outstanding_allow_amount>\n" +
                "    <show_public_prices>0</show_public_prices>\n" +
                "    <id_risk>0</id_risk>\n" +
                "    <max_payment_days>0</max_payment_days>\n" +
                "    <active>1</active>\n" +
                "    <note></note>\n" +
                "    <is_guest>0</is_guest>\n" +
                "    <id_shop>1</id_shop>\n" +
                "    <id_shop_group>1</id_shop_group>\n" +
                "    <date_add>2018-10-25 01:09:51</date_add>\n" +
                "    <date_upd>2018-10-25 01:09:51</date_upd>\n" +
                "    <reset_password_token></reset_password_token>\n" +
                "    <reset_password_validity>0000-00-00 00:00:00</reset_password_validity>\n" +
                "    <associations>\n" +
                "        <groups nodeType=\"group\" api=\"groups\">\n" +
                "            <group xlink:href=\"https://www.smeal.fr/api/groups/3\">\n" +
                "                <id>3</id>\n" +
                "            </group>\n" +
                "        </groups>\n" +
                "    </associations>\n" +
                "</customer>";
        String firstname = XmlUtil.getValue(xml, "firstname");
        System.out.println(firstname);

        String lastname = XmlUtil.getValue(xml, "lastname");
        System.out.println(lastname);

        String idDefaultGroup = XmlUtil.getValue(xml, "id_default_group");
        System.out.println(idDefaultGroup);
    }
}
