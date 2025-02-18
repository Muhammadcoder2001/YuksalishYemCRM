package com.BedanaYuksalish.BedanaYemlari.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@OpenAPIDefinition(
//        info = @io.swagger.v3.oas.annotations.info.Info(
//                contact = @io.swagger.v3.oas.annotations.info.Contact(
//                        name = "Muhammadcoder",
//                        email = "abduqahhorovmuhammadqobil@gmail.com",
//                        url = "https://t.me/software_engineer1417"
//                ),
//                description = "Quyida G'iybat.uz loyihasi uchun API hujjatlar tagdim qilingan.",
//                title = "G'iybat.uz API-lar",
//                version = "1.0",
//                license = @License(
//                        name = "Videohub",
//                        url = "https://videohub.uz/"
//                ),
//                termsOfService = "Savol javob guruhi: https://t.me/code_uz_group"
//        ),
//        servers = {
//                @io.swagger.v3.oas.annotations.servers.Server(
//                        description = "LOCAL",
//                        url = "http://localhost:8080/"
//                ),
//                @io.swagger.v3.oas.annotations.servers.Server(
//                        description = "DEV",
//                        url = "http://api.mazgi.uz"
//                )
//        },
//        security = {
//                @SecurityRequirement(
//                        name = "bearerAuth"
//                )
//        }
//)
//@SecurityScheme(
//        name = "bearerAuth",
//        description = "JWT auth description",
//        scheme = "bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)
public class SwaggerConfigAnnotation {

}
