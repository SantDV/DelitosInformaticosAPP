package com.example.myapplication.utils

import com.example.myapplication.utils.Constants.OPEN_GOOGLE
import com.example.myapplication.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.text.Normalizer


object BotResponse {

    private fun formatearCodigo(_mensaje: String):String{

        //pasa texto a minusculas
        var mensaje =_mensaje.lowercase()

        //Mensaje sin espacios
        mensaje = mensaje.replace("\\s".toRegex(), "")

        //Mensaje sin signos de pregunta
        mensaje = mensaje.replace("¿|\\?".toRegex(), "")

        //Mensaje sin comas
        mensaje = mensaje.replace(",".toRegex(), "")

        //Quitar tildes
        mensaje = Normalizer.normalize(mensaje, Normalizer.Form.NFD)
            .replace("\\p{M}".toRegex(), "")


        return mensaje
    }

    fun basicResponses(_message: String): String {

        val random = (0..2).random()

        //Envia el texto recibido por teclado a la funcion formatear, para que el texto sea entendido por el bot
        var message = formatearCodigo(_message)


        return when {

            //Saludo
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola!"
                    1 -> "Qué tal?"
                    2 -> "Buongiorno!"
                    3 -> "Hola, en qué puedo ayudarte?"
                    else -> "error" }
            }

            //Cómo estás?
            message.contains("comoestas?") || message.contains("holacomoestas") -> {
                when (random) {
                    0 -> "Muy bien, gracias!"
                    1 -> "Tengo hambre..."
                    2 -> "Muy bien! usted?"
                    else -> "error"
                }
            }

            //Qué hora es?
            message.contains("hora") || message.contains("quehoraes")|| message.contains("dimelahora")|| message.contains("decimelahora")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                "Aquí tienes la fecha y hora del día de hoy: \n $date"

            }

            //Abrir Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Buscar en internet
            message.contains("buscar") || message.contains("abrirnavegador")-> {
                OPEN_SEARCH
            }

            //Delito informático
            message.contains("queesundelitoinformatico")|| message.contains("delitosinformaticos")|| message.contains("delitoinformatico")-> {

                "Delito informático, delito cibernético o ciberdelito es toda aquella acción antijurídica que se realiza en el entorno digital, espacio digital o de Internet. Ante el extendido uso y utilización de las nuevas tecnologías en todas las esferas de la vida (economía, cultura, industria, ciencia, educación, información, comunicación, etc.) y el creciente número de usuarios, consecuencia de la globalización digital de la sociedad, la delincuencia también se ha expandido a esa dimensión. Gracias al anonimato y a la información personal que se guarda en el entorno digital, los delincuentes han ampliado su campo de acción y los delitos y amenazas a la seguridad se han incrementado exponencialmente."

            }

            //Delito informático
            message.contains("delitosinformaticosycyberseguridad") || message.contains("ley26388")|| message.contains("ley27411") || message.contains("delitosinformaticosyciberseguridad")-> {

                "Aquí tienes  un resumen sobre delitos infórmaticos y cyberseguridad: \n La Ley 26.388 de Argentina, también conocida como \"Ley de Delitos Informáticos\", establece las penas y sanciones para los delitos cometidos a través de medios electrónicos, informáticos y telemáticos. Esta ley fue sancionada en 2008 y busca proteger la privacidad y seguridad de las personas en el ámbito digital, fomentando el uso responsable y ético de los medios electrónicos y telemáticos.\n" +
                        "\n" +
                        "Por otro lado, la Ley 27.411 de Argentina aprueba la adhesión al Convenio de Budapest sobre Ciberdelito. Este convenio internacional tiene como objetivo combatir el ciberdelito y establece medidas para la protección de los derechos humanos y las libertades fundamentales en el ámbito digital. La ley 27.411 establece que el convenio tiene rango constitucional en Argentina, lo que significa que tiene la misma jerarquía que la Constitución Nacional.\n" +
                        "\n" +
                        "En resumen, ambas leyes tienen como objetivo proteger a las personas en el ámbito digital y establecer medidas para combatir el ciberdelito. La Ley de Delitos Informáticos establece las penas y sanciones para los delitos cometidos a través de medios electrónicos, mientras que la Ley de Aprobación del Convenio sobre Ciberdelito establece las medidas internacionales para combatir el ciberdelito."

            }

            //Privacidad y proteccion de datos personales
            //Delito informático
            message.contains("privacidadyprotecciondedatospersonales")|| message.contains("27275")|| message.contains("ley25326") || message.contains("datospersonales") || message.contains("privacidad") || message.contains("datospersonalesyprivacidad")-> {

                "Aquí tienes un resumen de las principales leyes sobre privacidad y proteccion de datos: \n La Constitución Nacional de Argentina establece en su Artículo 19 el principio de reserva, el cual garantiza la privacidad y la inviolabilidad de la correspondencia y de los documentos privados. Por otro lado, en el Artículo 43 se establece la acción de Habeas Data, que permite a cualquier persona conocer qué información se tiene sobre ella, quién la posee y con qué fines.\n" +
                        "\n" +
                        "La Ley 25.326 de Protección de los Datos Personales establece las normas para la protección de los datos personales en Argentina, tanto en el sector público como en el privado. Esta ley regula la recolección, almacenamiento, tratamiento y transferencia de datos personales, y establece los derechos de los titulares de los datos personales.\n" +
                        "\n" +
                        "El Decreto 1.558/2001 reglamenta la Ley de Protección de los Datos Personales, estableciendo las normas para su implementación y la creación del Registro Nacional de Bases de Datos.\n" +
                        "\n" +
                        "La Ley 27.275 del Derecho de Acceso a la Información Pública garantiza el derecho de los ciudadanos a acceder a la información que poseen los organismos del Estado, salvo excepciones previstas por ley. Esta ley promueve la transparencia y la rendición de cuentas en la gestión pública y establece los procedimientos para solicitar y obtener información pública."
            }

            message.contains("documentoelectronicoyfirmadigitales")|| message.contains("ley25506") || message.contains("firmadigital") || message.contains("documentoelectronico")-> {

                "Aquí tienes un resumen de las principales leyes sobre documentos electrónicos y firmas digitales: \n La Ley 25.506 de Firma Digital es una ley argentina que establece el marco legal para la utilización de la firma digital en documentos electrónicos, con el objetivo de darle a estos documentos la misma validez jurídica que los documentos en papel. La ley establece los requisitos que deben cumplir las firmas digitales para ser consideradas válidas, así como las condiciones para su utilización y los efectos legales de su utilización.\n" +
                        "\n" +
                        "El Decreto 2.628/02 reglamenta la Ley 25.506, y establece el procedimiento para la emisión, renovación y revocación de certificados de firma digital, así como las condiciones que deben cumplir las entidades que pueden emitir estos certificados. También establece las responsabilidades de los usuarios de la firma digital y las condiciones para su uso en transacciones electrónicas.\n" +
                        "\n" +
                        "En resumen, estas leyes establecen el marco legal para la utilización de la firma digital en documentos electrónicos en Argentina, con el objetivo de darle validez jurídica a estos documentos y fomentar la seguridad y eficiencia en las transacciones electrónicas."
            }

            message.contains("defensadelconsumidor")|| message.contains("ley22802")|| message.contains("ley25156")|| message.contains("ley26993")|| message.contains("ley26992")|| message.contains("ley26991") || message.contains("defensaalconsumidor") || message.contains("consumidor")-> {

                "Aquí tienes un resumen de las principales leyes sobre defensa del consumidor: \n La Ley 24.240 de Defensa al Consumidor es una ley argentina que establece los derechos de los consumidores y las obligaciones de los proveedores en las relaciones de consumo. La ley establece la obligación de los proveedores de informar clara y verazmente sobre los productos y servicios que ofrecen, y establece mecanismos de protección para los consumidores en caso de publicidad engañosa, prácticas abusivas o defectos en los productos y servicios.\n" +
                        "\n" +
                        "La Ley 26.991 crea la nueva regulación de las relaciones de producción y consumo en Argentina, estableciendo los derechos y obligaciones de los consumidores y proveedores en el mercado. La ley promueve la transparencia y la competencia en el mercado, y establece mecanismos de protección para los consumidores, como la obligación de informar sobre los riesgos y peligros de los productos y servicios que se ofrecen.\n" +
                        "\n" +
                        "La Ley 26.992 crea el Observatorio de Precios y Disponibilidad de Insumos, Bienes y Servicios, con el objetivo de monitorear los precios y la disponibilidad de los bienes y servicios en el mercado, para garantizar el acceso de los consumidores a precios justos y razonables.\n" +
                        "\n" +
                        "La Ley 26.993 crea el Sistema de Resolución de Conflictos en las Relaciones de Consumo, con el objetivo de establecer un mecanismo de resolución de conflictos entre consumidores y proveedores de bienes y servicios, de manera rápida, efectiva y justa.\n" +
                        "\n" +
                        "La Ley 25.156 de Defensa de la Competencia es una ley argentina que establece el marco legal para proteger y fomentar la competencia en el mercado, evitando prácticas monopólicas o cartelizadas que puedan perjudicar a los consumidores y a otros competidores.\n" +
                        "\n" +
                        "La Ley 22.802 de Lealtad Comercial establece las normas para la publicidad y las prácticas comerciales, estableciendo la obligación de los proveedores de ofrecer información veraz y no engañosa sobre los productos y servicios que ofrecen, y prohibiendo prácticas abusivas o desleales que puedan perjudicar a los consumidores o a otros competidores en el mercado."

            }

            message.contains("marcascomercialesypropiedadintelectual")|| message.contains("ley11723") || message.contains("marcascomerciales") || message.contains("propiedadintelectual")-> {

                "Aquí tienes un resumen de las principales leyes sobre marcas comerciales y propiedad intelectual: \n Las marcas comerciales y la propiedad intelectual son temas fundamentales para el funcionamiento de la economía y la protección de los derechos de los creadores y titulares de obras intelectuales. La Ley 22.362 de Marcas y Designaciones establece las condiciones y requisitos para el registro de marcas y designaciones comerciales en Argentina, mientras que la Resolución INPI 266/2012 implementa un sistema de gestión y cobro electrónico para agilizar y mejorar el proceso de registro.\n" +
                        "\n" +
                        "Por otro lado, la Ley 11.723 establece el régimen legal de la propiedad intelectual en Argentina y reconoce la protección de las obras literarias, artísticas y de los programas de computadora como obras intelectuales. El Decreto 41.223/1934 reglamenta esta ley y establece los procedimientos para su aplicación. Finalmente, la Ley 25.140 aprueba el Convenio de Berna para la Protección de las Obras Literarias y Artísticas, y dos tratados de la OMPI sobre interpretación, ejecución y fonogramas, y sobre derecho de autor, todos ellos destinados a proteger los derechos de autor a nivel internacional. En resumen, estas leyes y normativas son esenciales para proteger y fomentar la creatividad, la innovación y el comercio justo en Argentina y en todo el mundo"

            }

            message.contains("nombresdedominioygobernanza") || message.contains("gobernanza") || message.contains("dominios")|| message.contains("nombresdedominios") || message.contains("nombrededominio")|| message.contains("nombresdedominio")-> {

                "Aquí tienes un resumen de las principales leyes sobre Nombres de dominio y gobernanza: \n Los nombres de dominio son la dirección que utilizamos para acceder a un sitio web en internet. Su importancia radica en que nos permiten identificar de manera única a una página en la red y acceder a ella de manera sencilla. Por esta razón, existe una gobernanza de los nombres de dominio para garantizar su correcto uso y administración.\n" +
                        "\n" +
                        "En este contexto, la Resolución 80/2013 de la Dirección Nacional del Registro de Dominios de Internet establece una serie de normas y procedimientos para la administración de los nombres de dominio en Argentina. Esta ley busca promover un uso adecuado y responsable de los nombres de dominio, así como establecer los criterios para su registro y renovación.\n" +
                        "\n" +
                        "Entre las principales disposiciones de esta ley, se encuentra la obligación de registrar los nombres de dominio a través de agentes registradores autorizados y la obligación de cumplir con los términos y condiciones de uso establecidos por el Registro Nacional de Dominios de Internet de Argentina (NIC.AR).\n" +
                        "\n" +
                        "En resumen, la Resolución 80/2013 busca regular el uso y la gestión de los nombres de dominio en Argentina, estableciendo un marco normativo claro y preciso para su administración y protección."

            }

            message.contains("regimendeinternetydelastelecomunicaciones") || message.contains("regimendeinternet") || message.contains("regimendelastelecomunicaciones")|| message.contains("regimen")|| message.contains("regimendeinternetytelecomunicaciones")-> {

                "Aquí tienes un resumen de las principales leyes sobre Regimen de internet y de las telecomunicaciones: \n El régimen de internet y de las telecomunicaciones es un conjunto de normas y regulaciones que buscan garantizar el acceso, la calidad y la seguridad de los servicios de internet y telecomunicaciones en un país. En Argentina, existen varias leyes que establecen las condiciones y requisitos para la prestación de estos servicios.\n" +
                        "\n" +
                        "En este contexto, la Resolución N° 109/2016 del Organismo Regulador del Sistema Nacional de Aeropuertos (ORSNA) aprueba el “Estándar del Servicio de Provisión de Internet en forma Inalámbrica (WIFI) en los Aeropuertos del Grupo “A” del SISTEMA NACIONAL DE AEROPUERTOS (SNA)”. Esta ley busca establecer los criterios para la provisión de servicios de internet inalámbrica en los aeropuertos de mayor tráfico en el país.\n" +
                        "\n" +
                        "Por otro lado, la Resolución 13/2014 de la Secretaría de Comunicaciones crea la Comisión Argentina de Políticas de Internet (CAPI), con el objetivo de diseñar una estrategia nacional sobre Internet y su gobernanza, así como de articular la participación de los distintos actores involucrados en la provisión de servicios de internet y telecomunicaciones en el país.\n" +
                        "\n" +
                        "En resumen, las leyes mencionadas establecen los estándares y regulaciones necesarios para garantizar la calidad, la seguridad y el acceso a los servicios de internet y telecomunicaciones en Argentina. Esto permite mejorar la calidad de vida de los ciudadanos y fomentar el desarrollo de la economía digital en el país."

            }


            //Cuando el bot no entind...
            else -> {
                when (random) {
                    0 -> "No entiendo..."
                    1 -> "Intenta preguntarme algo diferente"
                    2 -> "No lo se :/"
                    else -> "error"
                }
            }
        }
    }
}