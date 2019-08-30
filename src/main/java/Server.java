import com.google.gson.Gson;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class Server {

    static MockServerClient mock = startClientAndServer(8081);

    public static void consulta(String method, String path, int statusCode, String content, String body, long delay){

        mock.when(
                request()
                        .withMethod(method)
                        .withPath(path)

        ).respond(
                response()
                        .withStatusCode(statusCode)
                        .withHeader(new Header("Content-Type", content))
                        .withBody(body)
                        .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );

    }

    public static void consulta(String path, int statusCode, String content, String body, long delay){

        mock.when(
                request()
                        .withMethod("GET")
                        .withPath(path)
                        .withBody("{\n" +
                                "\t\"token\" : \"12345\",\n" +
                                "\t\"username\" : \"eduflores\"\n" +
                                "}")

        ).respond(
                response()
                        .withStatusCode(statusCode)
                        .withHeader(new Header("Content-Type", content))
                        .withBody(body)
                        .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );

    }

    public static void main(String[] args){

        Gson gson = new Gson();
        String siteMock = "{\n" +
                "  \"id\": \"MLA\",\n" +
                "  \"name\": \"Argentina\",\n" +
                "  \"country_id\": \"AR\",\n" +
                "  \"sale_fees_mode\": \"not_free\",\n" +
                "  \"mercadopago_version\": 3,\n" +
                "  \"default_currency_id\": \"ARS\",\n" +
                "  \"immediate_payment\": \"optional\",\n" +
                "  \"payment_method_ids\": [\n" +
                "    \"MLAMP\",\n" +
                "    \"MLAWC\",\n" +
                "    \"MLAAM\",\n" +
                "    \"MLABC\",\n" +
                "    \"MLACD\",\n" +
                "    \"MLAOT\",\n" +
                "    \"MLADC\",\n" +
                "    \"MLAMO\",\n" +
                "    \"MLAWT\",\n" +
                "    \"MLAMC\",\n" +
                "    \"MLAMS\",\n" +
                "    \"MLAVS\",\n" +
                "    \"MLATB\",\n" +
                "    \"MLAVE\"\n" +
                "  ],\n" +
                "  \"settings\": {\n" +
                "    \"identification_types\": [\n" +
                "      \"DNI\",\n" +
                "      \"Otro\"\n" +
                "    ],\n" +
                "    \"taxpayer_types\": [\n" +
                "      \"IVA Exento\",\n" +
                "      \"IVA Responsable Inscripto\",\n" +
                "      \"Monotributo\",\n" +
                "      \"Consumidor Final\"\n" +
                "    ],\n" +
                "    \"identification_types_rules\": [\n" +
                "      {\n" +
                "        \"identification_type\": \"DNI\",\n" +
                "        \"rules\": [\n" +
                "          {\n" +
                "            \"enabled_taxpayer_types\": [\n" +
                "              \"Consumidor Final\"\n" +
                "            ],\n" +
                "            \"begins_with\": \"\",\n" +
                "            \"type\": \"number\",\n" +
                "            \"min_length\": 8,\n" +
                "            \"max_length\": 8\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"identification_type\": \"Otro\",\n" +
                "        \"rules\": [\n" +
                "          {\n" +
                "            \"enabled_taxpayer_types\": [\n" +
                "              \"IVA Exento\",\n" +
                "              \"IVA Responsable Inscripto\",\n" +
                "              \"Monotributo\"\n" +
                "            ],\n" +
                "            \"begins_with\": \"\",\n" +
                "            \"type\": \"number\",\n" +
                "            \"min_length\": 11,\n" +
                "            \"max_length\": 11\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"currencies\": [\n" +
                "    {\n" +
                "      \"id\": \"USD\",\n" +
                "      \"symbol\": \"U$S\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"ARS\",\n" +
                "      \"symbol\": \"$\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"categories\": [\n" +
                "    {\n" +
                "      \"id\": \"MLA5725\",\n" +
                "      \"name\": \"Accesorios para Vehículos\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1403\",\n" +
                "      \"name\": \"Alimentos y Bebidas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1071\",\n" +
                "      \"name\": \"Animales y Mascotas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1367\",\n" +
                "      \"name\": \"Antigüedades y Colecciones\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1368\",\n" +
                "      \"name\": \"Arte, Librería y Mercería\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1743\",\n" +
                "      \"name\": \"Autos, Motos y Otros\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1384\",\n" +
                "      \"name\": \"Bebés\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1246\",\n" +
                "      \"name\": \"Belleza y Cuidado Personal\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1039\",\n" +
                "      \"name\": \"Cámaras y Accesorios\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1051\",\n" +
                "      \"name\": \"Celulares y Teléfonos\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1648\",\n" +
                "      \"name\": \"Computación\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1144\",\n" +
                "      \"name\": \"Consolas y Videojuegos\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1276\",\n" +
                "      \"name\": \"Deportes y Fitness\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA5726\",\n" +
                "      \"name\": \"Electrodomésticos y Aires Ac.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1000\",\n" +
                "      \"name\": \"Electrónica, Audio y Video\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA2547\",\n" +
                "      \"name\": \"Entradas para Eventos\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA407134\",\n" +
                "      \"name\": \"Herramientas y Construcción\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1574\",\n" +
                "      \"name\": \"Hogar, Muebles y Jardín\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1499\",\n" +
                "      \"name\": \"Industrias y Oficinas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1459\",\n" +
                "      \"name\": \"Inmuebles\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1182\",\n" +
                "      \"name\": \"Instrumentos Musicales\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA3937\",\n" +
                "      \"name\": \"Joyas y Relojes\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1132\",\n" +
                "      \"name\": \"Juegos y Juguetes\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA3025\",\n" +
                "      \"name\": \"Libros, Revistas y Comics\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1168\",\n" +
                "      \"name\": \"Música, Películas y Series\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1430\",\n" +
                "      \"name\": \"Ropa y Accesorios\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA409431\",\n" +
                "      \"name\": \"Salud y Equipamiento Médico\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1540\",\n" +
                "      \"name\": \"Servicios\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA9304\",\n" +
                "      \"name\": \"Souvenirs, Cotillón y Fiestas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"MLA1953\",\n" +
                "      \"name\": \"Otras categorías\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String userMock = "{\n" +
                "  \"id\": 123456,\n" +
                "  \"nickname\": \"RADIUS\",\n" +
                "  \"registration_date\": \"1999-12-21T00:00:00.000-04:00\",\n" +
                "  \"country_id\": \"BR\",\n" +
                "  \"address\": {\n" +
                "    \"city\": \"Bauru\",\n" +
                "    \"state\": \"BR-SP\"\n" +
                "  },\n" +
                "  \"user_type\": \"normal\",\n" +
                "  \"tags\": [\n" +
                "    \"normal\"\n" +
                "  ],\n" +
                "  \"logo\": null,\n" +
                "  \"points\": 0,\n" +
                "  \"site_id\": \"MLB\",\n" +
                "  \"permalink\": \"http://perfil.mercadolivre.com.br/RADIUS\",\n" +
                "  \"seller_reputation\": {\n" +
                "    \"level_id\": null,\n" +
                "    \"power_seller_status\": null,\n" +
                "    \"transactions\": {\n" +
                "      \"canceled\": 0,\n" +
                "      \"completed\": 0,\n" +
                "      \"period\": \"historic\",\n" +
                "      \"ratings\": {\n" +
                "        \"negative\": 0,\n" +
                "        \"neutral\": 0,\n" +
                "        \"positive\": 0\n" +
                "      },\n" +
                "      \"total\": 0\n" +
                "    }\n" +
                "  },\n" +
                "  \"buyer_reputation\": {\n" +
                "    \"tags\": [\n" +
                "    ]\n" +
                "  },\n" +
                "  \"status\": {\n" +
                "    \"site_status\": \"active\"\n" +
                "  }\n" +
                "}";

        String countryMock = "{\n" +
                "  \"id\": \"AR\",\n" +
                "  \"name\": \"Argentina\",\n" +
                "  \"locale\": \"es_AR\",\n" +
                "  \"currency_id\": \"ARS\",\n" +
                "  \"decimal_separator\": \",\",\n" +
                "  \"thousands_separator\": \".\",\n" +
                "  \"time_zone\": \"GMT-03:00\",\n" +
                "  \"geo_information\": {\n" +
                "    \"location\": {\n" +
                "      \"latitude\": -38.416096,\n" +
                "      \"longitude\": -63.616673\n" +
                "    }\n" +
                "  },\n" +
                "  \"states\": [\n" +
                "    {\n" +
                "      \"id\": \"AR-B\",\n" +
                "      \"name\": \"Buenos Aires\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-C\",\n" +
                "      \"name\": \"Capital Federal\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-K\",\n" +
                "      \"name\": \"Catamarca\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-H\",\n" +
                "      \"name\": \"Chaco\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-U\",\n" +
                "      \"name\": \"Chubut\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-W\",\n" +
                "      \"name\": \"Corrientes\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-X\",\n" +
                "      \"name\": \"Córdoba\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-E\",\n" +
                "      \"name\": \"Entre Ríos\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-P\",\n" +
                "      \"name\": \"Formosa\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-Y\",\n" +
                "      \"name\": \"Jujuy\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-L\",\n" +
                "      \"name\": \"La Pampa\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-F\",\n" +
                "      \"name\": \"La Rioja\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-M\",\n" +
                "      \"name\": \"Mendoza\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-N\",\n" +
                "      \"name\": \"Misiones\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-Q\",\n" +
                "      \"name\": \"Neuquén\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-R\",\n" +
                "      \"name\": \"Río Negro\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-A\",\n" +
                "      \"name\": \"Salta\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-J\",\n" +
                "      \"name\": \"San Juan\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-D\",\n" +
                "      \"name\": \"San Luis\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-Z\",\n" +
                "      \"name\": \"Santa Cruz\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-S\",\n" +
                "      \"name\": \"Santa Fe\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-G\",\n" +
                "      \"name\": \"Santiago del Estero\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-V\",\n" +
                "      \"name\": \"Tierra del Fuego\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"AR-T\",\n" +
                "      \"name\": \"Tucumán\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
  /*    Users user = new Users(1, "12345", "eduflores");
        Categorie myCategori = new Categorie("MLA725", "Accesorios para Vehiculos");
        Site mySite = new Site("MLA", "Argentina",myCategori);
        Site mySiteSC = new Site("MLA", "Argentina");

*/
        consulta("GET","/users/123456",202,",application/json",userMock,3000);
        consulta("GET","/sites/MLB",202,",application/json",siteMock ,5000);
        consulta("GET","/countries/BR",202,",application/json", countryMock,4000);


    }


}
