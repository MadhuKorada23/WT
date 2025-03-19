<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Output in HTML -->
    <xsl:output method="html" encoding="UTF-8" />

    <!-- Template to match the root element -->
    <xsl:template match="/">
        <html>
        <head>
            <title>Bookstore Catalogue</title>
            <style>
                body { font-family: Arial, sans-serif; margin: 20px; }
                h1 { color: #2a7ae2; }
                table { width: 100%; border-collapse: collapse; margin-top: 20px; }
                th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
                th { background-color: #2a7ae2; color: white; }
                tr:nth-child(even) { background-color: #f2f2f2; }
            </style>
        </head>
        <body>
            <h1>Bookstore Catalogue</h1>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>ISBN</th>
                    <th>Publisher</th>
                    <th>Edition</th>
                    <th>Price ($)</th>
                </tr>
                
                <!-- Iterate through each book -->
                <xsl:for-each select="bookstore/book">
                    <tr>
                        <td><xsl:value-of select="title" /></td>
                        <td><xsl:value-of select="author" /></td>
                        <td><xsl:value-of select="isbn" /></td>
                        <td><xsl:value-of select="publisher" /></td>
                        <td><xsl:value-of select="edition" /></td>
                        <td><xsl:value-of select="price" /></td>
                    </tr>
                </xsl:for-each>

            </table>
        </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
