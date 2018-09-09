package com.example.vicky.sqliteoptimization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dbHandler : DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHandler = DataBaseHandler(this)
        btn_insert_data.setOnClickListener {
            Log.d("MainActivity" , " start : ${Date().time}")
//            getData().forEach {
//                dbHandler.insertOrUpdate(it)
//            }
            dbHandler.InsertOrUpdateTransaction(getData())
            Log.d("MainActivity" , " end : ${Date().time}")
            Log.d("MainActivity" , " getCount : ${dbHandler.getCount()}")
        }

    }


    private fun getData(): MutableList<CountryDTO> {
        val json = "{\n" +
                "\t\"countryCode\" : [{\"country\":\"Afghanistan\",\"calling_code\":\"93\"},\n" +
                "{\"country\":\"Albania\",\"calling_code\":\"355\"},\n" +
                "{\"country\":\"Algeria\",\"calling_code\":\"213\"},\n" +
                "{\"country\":\"American Samoa\",\"calling_code\":\"1684\"},\n" +
                "{\"country\":\"Andorra\",\"calling_code\":\"376\"},\n" +
                "{\"country\":\"Angola\",\"calling_code\":\"244\"},\n" +
                "{\"country\":\"Anguilla\",\"calling_code\":\"1264\"},\n" +
                "{\"country\":\"Antarctica\",\"calling_code\":null},\n" +
                "{\"country\":\"Antigua and Barbuda\",\"calling_code\":\"1268\"},\n" +
                "{\"country\":\"Argentina\",\"calling_code\":\"54\"},\n" +
                "{\"country\":\"Armenia\",\"calling_code\":\"374\"},\n" +
                "{\"country\":\"Aruba\",\"calling_code\":\"297\"},\n" +
                "{\"country\":\"Australia\",\"calling_code\":\"61\"},\n" +
                "{\"country\":\"Austria\",\"calling_code\":\"43\"},\n" +
                "{\"country\":\"Azerbaijan\",\"calling_code\":\"994\"},\n" +
                "{\"country\":\"Bahamas\",\"calling_code\":\"1242\"},\n" +
                "{\"country\":\"Bahrain\",\"calling_code\":\"973\"},\n" +
                "{\"country\":\"Bangladesh\",\"calling_code\":\"880\"},\n" +
                "{\"country\":\"Barbados\",\"calling_code\":\"1246\"},\n" +
                "{\"country\":\"Belarus\",\"calling_code\":\"375\"},\n" +
                "{\"country\":\"Belgium\",\"calling_code\":\"32\"},\n" +
                "{\"country\":\"Belize\",\"calling_code\":\"501\"},\n" +
                "{\"country\":\"Benin\",\"calling_code\":\"229\"},\n" +
                "{\"country\":\"Bermuda\",\"calling_code\":\"1441\"},\n" +
                "{\"country\":\"Bhutan\",\"calling_code\":\"975\"},\n" +
                "{\"country\":\"Bolivia\",\"calling_code\":\"591\"},\n" +
                "{\"country\":\"Bosnia and Herzegovina\",\"calling_code\":\"387\"},\n" +
                "{\"country\":\"Botswana\",\"calling_code\":\"267\"},\n" +
                "{\"country\":\"Bouvet Island\",\"calling_code\":null},\n" +
                "{\"country\":\"Brazil\",\"calling_code\":\"55\"},\n" +
                "{\"country\":\"British Indian Ocean Territory\",\"calling_code\":\"246\"},\n" +
                "{\"country\":\"Brunei\",\"calling_code\":null},\n" +
                "{\"country\":\"Bulgaria\",\"calling_code\":\"359\"},\n" +
                "{\"country\":\"Burkina Faso\",\"calling_code\":\"226\"},\n" +
                "{\"country\":\"Burundi\",\"calling_code\":\"257\"},\n" +
                "{\"country\":\"Cambodia\",\"calling_code\":\"855\"},\n" +
                "{\"country\":\"Cameroon\",\"calling_code\":\"237\"},\n" +
                "{\"country\":\"Canada\",\"calling_code\":\"1\"},\n" +
                "{\"country\":\"Cape Verde\",\"calling_code\":null},\n" +
                "{\"country\":\"Cayman Islands\",\"calling_code\":\"1345\"},\n" +
                "{\"country\":\"Central African Republic\",\"calling_code\":\"236\"},\n" +
                "{\"country\":\"Chad\",\"calling_code\":\"235\"},\n" +
                "{\"country\":\"Chile\",\"calling_code\":\"56\"},\n" +
                "{\"country\":\"China\",\"calling_code\":\"86\"},\n" +
                "{\"country\":\"Christmas Island\",\"calling_code\":\"61\"},\n" +
                "{\"country\":\"Cocos (Keeling) Islands\",\"calling_code\":\"61\"},\n" +
                "{\"country\":\"Colombia\",\"calling_code\":\"57\"},\n" +
                "{\"country\":\"Comoros\",\"calling_code\":\"269\"},\n" +
                "{\"country\":\"Congo\",\"calling_code\":\"242\"},\n" +
                "{\"country\":\"Cook Islands\",\"calling_code\":\"682\"},\n" +
                "{\"country\":\"Costa Rica\",\"calling_code\":\"506\"},\n" +
                "{\"country\":\"Croatia\",\"calling_code\":\"385\"},\n" +
                "{\"country\":\"Cuba\",\"calling_code\":\"53\"},\n" +
                "{\"country\":\"Cyprus\",\"calling_code\":\"357\"},\n" +
                "{\"country\":\"Czech Republic\",\"calling_code\":\"420\"},\n" +
                "{\"country\":\"Denmark\",\"calling_code\":\"45\"},\n" +
                "{\"country\":\"Djibouti\",\"calling_code\":\"253\"},\n" +
                "{\"country\":\"Dominica\",\"calling_code\":\"1767\"},\n" +
                "{\"country\":\"Dominican Republic\",\"calling_code\":\"1849\"},\n" +
                "{\"country\":\"East Timor\",\"calling_code\":\"670\"},\n" +
                "{\"country\":\"Ecuador\",\"calling_code\":\"593\"},\n" +
                "{\"country\":\"Egypt\",\"calling_code\":\"20\"},\n" +
                "{\"country\":\"El Salvador\",\"calling_code\":\"503\"},\n" +
                "{\"country\":\"England\",\"calling_code\":null},\n" +
                "{\"country\":\"Equatorial Guinea\",\"calling_code\":\"240\"},\n" +
                "{\"country\":\"Eritrea\",\"calling_code\":\"291\"},\n" +
                "{\"country\":\"Estonia\",\"calling_code\":\"372\"},\n" +
                "{\"country\":\"Ethiopia\",\"calling_code\":\"251\"},\n" +
                "{\"country\":\"Falkland Islands\",\"calling_code\":\"500\"},\n" +
                "{\"country\":\"Faroe Islands\",\"calling_code\":\"298\"},\n" +
                "{\"country\":\"Fiji Islands\",\"calling_code\":null},\n" +
                "{\"country\":\"Finland\",\"calling_code\":\"358\"},\n" +
                "{\"country\":\"France\",\"calling_code\":\"33\"},\n" +
                "{\"country\":\"French Guiana\",\"calling_code\":\"594\"},\n" +
                "{\"country\":\"French Polynesia\",\"calling_code\":\"689\"},\n" +
                "{\"country\":\"French Southern territories\",\"calling_code\":null},\n" +
                "{\"country\":\"Gabon\",\"calling_code\":\"241\"},\n" +
                "{\"country\":\"Gambia\",\"calling_code\":\"220\"},\n" +
                "{\"country\":\"Georgia\",\"calling_code\":\"995\"},\n" +
                "{\"country\":\"Germany\",\"calling_code\":\"49\"},\n" +
                "{\"country\":\"Ghana\",\"calling_code\":\"233\"},\n" +
                "{\"country\":\"Gibraltar\",\"calling_code\":\"350\"},\n" +
                "{\"country\":\"Greece\",\"calling_code\":\"30\"},\n" +
                "{\"country\":\"Greenland\",\"calling_code\":\"299\"},\n" +
                "{\"country\":\"Grenada\",\"calling_code\":\"1473\"},\n" +
                "{\"country\":\"Guadeloupe\",\"calling_code\":\"590\"},\n" +
                "{\"country\":\"Guam\",\"calling_code\":\"1671\"},\n" +
                "{\"country\":\"Guatemala\",\"calling_code\":\"502\"},\n" +
                "{\"country\":\"Guinea\",\"calling_code\":\"224\"},\n" +
                "{\"country\":\"Guinea-Bissau\",\"calling_code\":\"245\"},\n" +
                "{\"country\":\"Guyana\",\"calling_code\":\"592\"},\n" +
                "{\"country\":\"Haiti\",\"calling_code\":\"509\"},\n" +
                "{\"country\":\"Heard Island and McDonald Islands\",\"calling_code\":null},\n" +
                "{\"country\":\"Holy See (Vatican City State)\",\"calling_code\":null},\n" +
                "{\"country\":\"Honduras\",\"calling_code\":\"504\"},\n" +
                "{\"country\":\"Hong Kong\",\"calling_code\":\"852\"},\n" +
                "{\"country\":\"Hungary\",\"calling_code\":\"36\"},\n" +
                "{\"country\":\"Iceland\",\"calling_code\":\"354\"},\n" +
                "{\"country\":\"India\",\"calling_code\":\"91\"},\n" +
                "{\"country\":\"Indonesia\",\"calling_code\":\"62\"},\n" +
                "{\"country\":\"Iran\",\"calling_code\":\"98\"},\n" +
                "{\"country\":\"Iraq\",\"calling_code\":\"964\"},\n" +
                "{\"country\":\"Ireland\",\"calling_code\":\"353\"},\n" +
                "{\"country\":\"Israel\",\"calling_code\":\"972\"},\n" +
                "{\"country\":\"Italy\",\"calling_code\":\"39\"},\n" +
                "{\"country\":\"Ivory Coast\",\"calling_code\":\"225\"},\n" +
                "{\"country\":\"Jamaica\",\"calling_code\":\"1876\"},\n" +
                "{\"country\":\"Japan\",\"calling_code\":\"81\"},\n" +
                "{\"country\":\"Jordan\",\"calling_code\":\"962\"},\n" +
                "{\"country\":\"Kazakstan\",\"calling_code\":null},\n" +
                "{\"country\":\"Kenya\",\"calling_code\":\"254\"},\n" +
                "{\"country\":\"Kiribati\",\"calling_code\":\"686\"},\n" +
                "{\"country\":\"Kuwait\",\"calling_code\":\"965\"},\n" +
                "{\"country\":\"Kyrgyzstan\",\"calling_code\":\"996\"},\n" +
                "{\"country\":\"Laos\",\"calling_code\":\"856\"},\n" +
                "{\"country\":\"Latvia\",\"calling_code\":\"371\"},\n" +
                "{\"country\":\"Lebanon\",\"calling_code\":\"961\"},\n" +
                "{\"country\":\"Lesotho\",\"calling_code\":\"266\"},\n" +
                "{\"country\":\"Liberia\",\"calling_code\":\"231\"},\n" +
                "{\"country\":\"Libyan Arab Jamahiriya\",\"calling_code\":null},\n" +
                "{\"country\":\"Liechtenstein\",\"calling_code\":\"423\"},\n" +
                "{\"country\":\"Lithuania\",\"calling_code\":\"370\"},\n" +
                "{\"country\":\"Luxembourg\",\"calling_code\":\"352\"},\n" +
                "{\"country\":\"Macao\",\"calling_code\":null},\n" +
                "{\"country\":\"Macedonia\",\"calling_code\":\"389\"},\n" +
                "{\"country\":\"Madagascar\",\"calling_code\":\"261\"},\n" +
                "{\"country\":\"Malawi\",\"calling_code\":\"265\"},\n" +
                "{\"country\":\"Malaysia\",\"calling_code\":\"60\"},\n" +
                "{\"country\":\"Maldives\",\"calling_code\":\"960\"},\n" +
                "{\"country\":\"Mali\",\"calling_code\":\"223\"},\n" +
                "{\"country\":\"Malta\",\"calling_code\":\"356\"},\n" +
                "{\"country\":\"Marshall Islands\",\"calling_code\":\"692\"},\n" +
                "{\"country\":\"Martinique\",\"calling_code\":\"596\"},\n" +
                "{\"country\":\"Mauritania\",\"calling_code\":\"222\"},\n" +
                "{\"country\":\"Mauritius\",\"calling_code\":\"230\"},\n" +
                "{\"country\":\"Mayotte\",\"calling_code\":\"262\"},\n" +
                "{\"country\":\"Mexico\",\"calling_code\":\"52\"},\n" +
                "{\"country\":\"Micronesia, Federated States of\",\"calling_code\":\"691\"},\n" +
                "{\"country\":\"Moldova\",\"calling_code\":\"373\"},\n" +
                "{\"country\":\"Monaco\",\"calling_code\":\"377\"},\n" +
                "{\"country\":\"Mongolia\",\"calling_code\":\"976\"},\n" +
                "{\"country\":\"Montserrat\",\"calling_code\":\"1664\"},\n" +
                "{\"country\":\"Morocco\",\"calling_code\":\"212\"},\n" +
                "{\"country\":\"Mozambique\",\"calling_code\":\"258\"},\n" +
                "{\"country\":\"Myanmar\",\"calling_code\":\"95\"},\n" +
                "{\"country\":\"Namibia\",\"calling_code\":\"264\"},\n" +
                "{\"country\":\"Nauru\",\"calling_code\":\"674\"},\n" +
                "{\"country\":\"Nepal\",\"calling_code\":\"977\"},\n" +
                "{\"country\":\"Netherlands\",\"calling_code\":\"31\"},\n" +
                "{\"country\":\"Netherlands Antilles\",\"calling_code\":null},\n" +
                "{\"country\":\"New Caledonia\",\"calling_code\":\"687\"},\n" +
                "{\"country\":\"New Zealand\",\"calling_code\":\"64\"},\n" +
                "{\"country\":\"Nicaragua\",\"calling_code\":\"505\"},\n" +
                "{\"country\":\"Niger\",\"calling_code\":\"227\"},\n" +
                "{\"country\":\"Nigeria\",\"calling_code\":\"234\"},\n" +
                "{\"country\":\"Niue\",\"calling_code\":\"683\"},\n" +
                "{\"country\":\"Norfolk Island\",\"calling_code\":\"672\"},\n" +
                "{\"country\":\"North Korea\",\"calling_code\":null},\n" +
                "{\"country\":\"Northern Ireland\",\"calling_code\":null},\n" +
                "{\"country\":\"Northern Mariana Islands\",\"calling_code\":\"1670\"},\n" +
                "{\"country\":\"Norway\",\"calling_code\":\"47\"},\n" +
                "{\"country\":\"Oman\",\"calling_code\":\"968\"},\n" +
                "{\"country\":\"Pakistan\",\"calling_code\":\"92\"},\n" +
                "{\"country\":\"Palau\",\"calling_code\":\"680\"},\n" +
                "{\"country\":\"Palestine\",\"calling_code\":null},\n" +
                "{\"country\":\"Panama\",\"calling_code\":\"507\"},\n" +
                "{\"country\":\"Papua New Guinea\",\"calling_code\":\"675\"},\n" +
                "{\"country\":\"Paraguay\",\"calling_code\":\"595\"},\n" +
                "{\"country\":\"Peru\",\"calling_code\":\"51\"},\n" +
                "{\"country\":\"Philippines\",\"calling_code\":\"63\"},\n" +
                "{\"country\":\"Pitcairn\",\"calling_code\":null},\n" +
                "{\"country\":\"Poland\",\"calling_code\":\"48\"},\n" +
                "{\"country\":\"Portugal\",\"calling_code\":\"351\"},\n" +
                "{\"country\":\"Puerto Rico\",\"calling_code\":\"1939\"},\n" +
                "{\"country\":\"Qatar\",\"calling_code\":\"974\"},\n" +
                "{\"country\":\"Reunion\",\"calling_code\":\"262\"},\n" +
                "{\"country\":\"Romania\",\"calling_code\":\"40\"},\n" +
                "{\"country\":\"Russian Federation\",\"calling_code\":null},\n" +
                "{\"country\":\"Rwanda\",\"calling_code\":\"250\"},\n" +
                "{\"country\":\"Saint Helena\",\"calling_code\":\"290\"},\n" +
                "{\"country\":\"Saint Kitts and Nevis\",\"calling_code\":\"1869\"},\n" +
                "{\"country\":\"Saint Lucia\",\"calling_code\":\"1758\"},\n" +
                "{\"country\":\"Saint Pierre and Miquelon\",\"calling_code\":\"508\"},\n" +
                "{\"country\":\"Saint Vincent and the Grenadines\",\"calling_code\":\"1784\"},\n" +
                "{\"country\":\"Samoa\",\"calling_code\":\"685\"},\n" +
                "{\"country\":\"San Marino\",\"calling_code\":\"378\"},\n" +
                "{\"country\":\"Sao Tome and Principe\",\"calling_code\":\"239\"},\n" +
                "{\"country\":\"Saudi Arabia\",\"calling_code\":\"966\"},\n" +
                "{\"country\":\"Scotland\",\"calling_code\":null},\n" +
                "{\"country\":\"Senegal\",\"calling_code\":\"221\"},\n" +
                "{\"country\":\"Seychelles\",\"calling_code\":\"248\"},\n" +
                "{\"country\":\"Sierra Leone\",\"calling_code\":\"232\"},\n" +
                "{\"country\":\"Singapore\",\"calling_code\":\"65\"},\n" +
                "{\"country\":\"Slovakia\",\"calling_code\":\"421\"},\n" +
                "{\"country\":\"Slovenia\",\"calling_code\":\"386\"},\n" +
                "{\"country\":\"Solomon Islands\",\"calling_code\":\"677\"},\n" +
                "{\"country\":\"Somalia\",\"calling_code\":\"252\"},\n" +
                "{\"country\":\"South Africa\",\"calling_code\":\"27\"},\n" +
                "{\"country\":\"South Georgia and the South Sandwich Islands\",\"calling_code\":\"500\"},\n" +
                "{\"country\":\"South Korea\",\"calling_code\":null},\n" +
                "{\"country\":\"South Sudan\",\"calling_code\":\"211\"},\n" +
                "{\"country\":\"Spain\",\"calling_code\":\"34\"},\n" +
                "{\"country\":\"SriLanka\",\"calling_code\":null},\n" +
                "{\"country\":\"Sudan\",\"calling_code\":\"249\"},\n" +
                "{\"country\":\"Suriname\",\"calling_code\":\"597\"},\n" +
                "{\"country\":\"Svalbard and Jan Mayen\",\"calling_code\":null},\n" +
                "{\"country\":\"Swaziland\",\"calling_code\":\"268\"},\n" +
                "{\"country\":\"Sweden\",\"calling_code\":\"46\"},\n" +
                "{\"country\":\"Switzerland\",\"calling_code\":\"41\"},\n" +
                "{\"country\":\"Syria\",\"calling_code\":\"963\"},\n" +
                "{\"country\":\"Tajikistan\",\"calling_code\":\"992\"},\n" +
                "{\"country\":\"Tanzania\",\"calling_code\":\"255\"},\n" +
                "{\"country\":\"Thailand\",\"calling_code\":\"66\"},\n" +
                "{\"country\":\"The Democratic Republic of Congo\",\"calling_code\":null},\n" +
                "{\"country\":\"Togo\",\"calling_code\":\"228\"},\n" +
                "{\"country\":\"Tokelau\",\"calling_code\":\"690\"},\n" +
                "{\"country\":\"Tonga\",\"calling_code\":\"676\"},\n" +
                "{\"country\":\"Trinidad and Tobago\",\"calling_code\":\"1868\"},\n" +
                "{\"country\":\"Tunisia\",\"calling_code\":\"216\"},\n" +
                "{\"country\":\"Turkey\",\"calling_code\":\"90\"},\n" +
                "{\"country\":\"Turkmenistan\",\"calling_code\":\"993\"},\n" +
                "{\"country\":\"Turks and Caicos Islands\",\"calling_code\":\"1649\"},\n" +
                "{\"country\":\"Tuvalu\",\"calling_code\":\"688\"},\n" +
                "{\"country\":\"Uganda\",\"calling_code\":\"256\"},\n" +
                "{\"country\":\"Ukraine\",\"calling_code\":\"380\"},\n" +
                "{\"country\":\"United Arab Emirates\",\"calling_code\":\"971\"},\n" +
                "{\"country\":\"United Kingdom\",\"calling_code\":\"44\"},\n" +
                "{\"country\":\"United States\",\"calling_code\":\"1\"},\n" +
                "{\"country\":\"United States Minor Outlying Islands\",\"calling_code\":null},\n" +
                "{\"country\":\"Uruguay\",\"calling_code\":\"598\"},\n" +
                "{\"country\":\"Uzbekistan\",\"calling_code\":\"998\"},\n" +
                "{\"country\":\"Vanuatu\",\"calling_code\":\"678\"},\n" +
                "{\"country\":\"Venezuela\",\"calling_code\":\"58\"},\n" +
                "{\"country\":\"Vietnam\",\"calling_code\":\"84\"},\n" +
                "{\"country\":\"Virgin Islands, British\",\"calling_code\":null},\n" +
                "{\"country\":\"Virgin Islands, U.S.\",\"calling_code\":null},\n" +
                "{\"country\":\"Wales\",\"calling_code\":null},\n" +
                "{\"country\":\"Wallis and Futuna\",\"calling_code\":\"681\"},\n" +
                "{\"country\":\"Western Sahara\",\"calling_code\":null},\n" +
                "{\"country\":\"Yemen\",\"calling_code\":\"967\"},\n" +
                "{\"country\":\"Yugoslavia\",\"calling_code\":null},\n" +
                "{\"country\":\"Zambia\",\"calling_code\":\"260\"},\n" +
                "{\"country\":\"Zimbabwe\",\"calling_code\":\"263\"}]\n" +
                "}"

        val countries = Gson().fromJson(json, CountryDTO::class.java)
        return countries.countryCode
    }
}
