package it.reply.iriscube.unito.app.activity.mock

/**
 * Created by Reply on 2020-04-18.
 */

object MockResponse {

    val getAddressBookResponse = """
                    {
                        "page": 1,
                        "per_page": 3,
                        "total": 12,
                        "total_pages": 4,
                        "data": [
                            {
                                "id": 1,
                                "email": "george.bluth@gmail.com",
                                "first_name": "George",
                                "last_name": "Bluth",
                                "avatar": ""
                            },
                            {
                                "id": 2,
                                "email": "janet.weaver@yahoo.com",
                                "first_name": "Janet",
                                "last_name": "Weaver",
                                "avatar": ""
                            },
                            {
                                "id": 3,
                                "email": "emma.wong@gmail.com",
                                "first_name": "Emma",
                                "last_name": "Wong",
                                "avatar": ""
                            }
                        ]
                    }
                """.trimIndent()

}
