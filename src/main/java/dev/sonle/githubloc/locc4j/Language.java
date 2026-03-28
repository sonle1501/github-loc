/*
 * Copyright 2024 C Thing Software
 * SPDX-License-Identifier: Apache-2.0
 */

// GENERATED FILE - DO NOT EDIT

package dev.sonle.githubloc.locc4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;



import static java.util.regex.Pattern.compile;

/**
 * Languages that can be counted. Click on a language to see the list of file extensions and/or file names
 * used by the language.
 */
@SuppressWarnings({
        "OptionalUsedAsFieldOrParameterType", "MethodDoesntCallSuperMethod",
        "Convert2streamapi", "ForLoopReplaceableByForEach", "UnnecessaryUnicodeEscape",
        "RegExpDuplicateAlternationBranch", "RegExpRedundantEscape"
})
public enum Language {
    /**
     * Advanced Business Application Programming language by SAP.
     * 
     * <p>File extensions: {@code abap}</p>
     * 
     * @see <a href="https://help.sap.com/doc/abapdocu_latest_index_htm/latest/en-US/index.htm?file=abenabap_reference.htm">https://help.sap.com/doc/abapdocu_latest_index_htm/latest/en-US/index.htm?file=abenabap_reference.htm</a>
     */
    Abap(
        "ABAP",
        "Advanced Business Application Programming language by SAP",
        "https://help.sap.com/doc/abapdocu_latest_index_htm/latest/en-US/index.htm?file=abenabap_reference.htm",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"abap"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("*") || predicate.test("\"");
        }

    },
    /**
     * Augmented Backus–Naur form metalanguage.
     * 
     * <p>File extensions: {@code abnf}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form">https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form</a>
     */
    ABNF(
        "ABNF",
        "Augmented Backus–Naur form metalanguage",
        "https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_form",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"abnf"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Adobe ActionScript programming language.
     * 
     * <p>File extensions: {@code as}</p>
     * 
     * @see <a href="https://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/index.html">https://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/index.html</a>
     */
    ActionScript(
        "ActionScript",
        "Adobe ActionScript programming language",
        "https://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/index.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"as"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Ada programming language.
     * 
     * <p>File extensions: {@code ada}, {@code adb}, {@code ads}, {@code pad}</p>
     * 
     * @see <a href="https://ada-lang.io/">https://ada-lang.io/</a>
     */
    Ada(
        "Ada",
        "Ada programming language",
        "https://ada-lang.io/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"ada", "adb", "ads", "pad"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Agda programming language.
     * 
     * <p>File extensions: {@code agda}</p>
     * 
     * @see <a href="https://wiki.portal.chalmers.se/agda/Main/HomePage">https://wiki.portal.chalmers.se/agda/Main/HomePage</a>
     */
    Agda(
        "Agda",
        "Agda programming language",
        "https://wiki.portal.chalmers.se/agda/Main/HomePage",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"agda"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Alex lexical analyzer generator specification.
     * 
     * <p>File extensions: {@code x}</p>
     * 
     * @see <a href="https://haskell-alex.readthedocs.io/en/latest/">https://haskell-alex.readthedocs.io/en/latest/</a>
     */
    Alex(
        "Alex",
        "Alex lexical analyzer generator specification",
        "https://haskell-alex.readthedocs.io/en/latest/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"x"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Alloy language and analyzer for software modeling.
     * 
     * <p>File extensions: {@code als}</p>
     * 
     * @see <a href="https://alloytools.org/">https://alloytools.org/</a>
     */
    Alloy(
        "Alloy",
        "Alloy language and analyzer for software modeling",
        "https://alloytools.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*"),
        new String[] {"als"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--") || predicate.test("//");
        }

    },
    /**
     * A Programming Language.
     * 
     * <p>File extensions: {@code apl}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/APL_(programming_language)">https://en.wikipedia.org/wiki/APL_(programming_language)</a>
     */
    Apl(
        "Apl",
        "A Programming Language",
        "https://en.wikipedia.org/wiki/APL_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"apl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("\u235D");
        }

    },
    /**
     * Arduino C++ programming language.
     * 
     * <p>File extensions: {@code ino}</p>
     * 
     * @see <a href="https://www.arduino.cc/reference/">https://www.arduino.cc/reference/</a>
     */
    Arduino(
        "Arduino C++",
        "Arduino C++ programming language",
        "https://www.arduino.cc/reference/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ino"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * AsciiDoc plain text markup language.
     * 
     * <p>File extensions: {@code adoc}, {@code asciidoc}</p>
     * 
     * @see <a href="https://asciidoc.org/">https://asciidoc.org/</a>
     */
    AsciiDoc(
        "AsciiDoc",
        "AsciiDoc plain text markup language",
        "https://asciidoc.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("////"),
        new String[] {"adoc", "asciidoc"},
        new BlockDelimiter[] {new BlockDelimiter("////", "////")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Abstract Syntax Notation One standard interface description language.
     * 
     * <p>File extensions: {@code asn1}, {@code mib}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/ASN.1">https://en.wikipedia.org/wiki/ASN.1</a>
     */
    Asn1(
        "ASN.1",
        "Abstract Syntax Notation One standard interface description language",
        "https://en.wikipedia.org/wiki/ASN.1",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"asn1", "mib"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Microsoft Active Server Pages server-side scripting language.
     * 
     * <p>File extensions: {@code asa}, {@code asp}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Active_Server_Pages">https://en.wikipedia.org/wiki/Active_Server_Pages</a>
     */
    Asp(
        "ASP",
        "Microsoft Active Server Pages server-side scripting language",
        "https://en.wikipedia.org/wiki/Active_Server_Pages",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"asa", "asp"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("'") || predicate.test("REM");
        }

    },
    /**
     * Microsoft .NET Active Server Pages server-side scripting language.
     * 
     * <p>File extensions: {@code asax}, {@code ascx}, {@code asmx}, {@code aspx}, {@code master}, {@code sitemap}, {@code webinfo}</p>
     * 
     * @see <a href="https://dotnet.microsoft.com/en-us/apps/aspnet">https://dotnet.microsoft.com/en-us/apps/aspnet</a>
     */
    AspNet(
        "ASP.NET",
        "Microsoft .NET Active Server Pages server-side scripting language",
        "https://dotnet.microsoft.com/en-us/apps/aspnet",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--|<%--"),
        new String[] {"asax", "ascx", "asmx", "aspx", "master", "sitemap", "webinfo"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("<%--", "-->")}
    ) {
    },
    /**
     * Assembly language.
     * 
     * <p>File extensions: {@code asm}</p>
     * 
     * @see <a href="https://docs.fileformat.com/programming/asm/">https://docs.fileformat.com/programming/asm/</a>
     */
    Assembly(
        "Assembly",
        "Assembly language",
        "https://docs.fileformat.com/programming/asm/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"asm"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Assembly language styled for the GNU Assembler.
     * 
     * <p>File extensions: {@code s}</p>
     * 
     * @see <a href="https://sourceware.org/binutils/docs/as/">https://sourceware.org/binutils/docs/as/</a>
     */
    AssemblyGAS(
        "GNU Style Assembly",
        "Assembly language styled for the GNU Assembler",
        "https://sourceware.org/binutils/docs/as/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"s"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Astro web framework for building content-driven websites.
     * 
     * <p>File extensions: {@code astro}</p>
     * 
     * @see <a href="https://astro.build/">https://astro.build/</a>
     */
    Astro(
        "Astro",
        "Astro web framework for building content-driven websites",
        "https://astro.build/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*|<!--"),
        new String[] {"astro"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/"), new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * ATS programming language.
     * 
     * <p>File extensions: {@code dats}, {@code hats}, {@code sats}, {@code atxt}</p>
     * 
     * @see <a href="https://ats-lang.github.io/DOCUMENT/INT2PROGINATS/HTML/book1.html">https://ats-lang.github.io/DOCUMENT/INT2PROGINATS/HTML/book1.html</a>
     */
    Ats(
        "ATS",
        "ATS programming language",
        "https://ats-lang.github.io/DOCUMENT/INT2PROGINATS/HTML/book1.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*|/\\*"),
        new String[] {"dats", "hats", "sats", "atxt"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)"), new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * GNU Autoconf tool input specification.
     * 
     * <p>File extensions: {@code in}</p>
     * 
     * @see <a href="https://www.gnu.org/savannah-checkouts/gnu/autoconf/manual/autoconf-2.72/autoconf.html">https://www.gnu.org/savannah-checkouts/gnu/autoconf/manual/autoconf-2.72/autoconf.html</a>
     */
    Autoconf(
        "Autoconf",
        "GNU Autoconf tool input specification",
        "https://www.gnu.org/savannah-checkouts/gnu/autoconf/manual/autoconf-2.72/autoconf.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"in"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("dnl");
        }

    },
    /**
     * AutoIt v3 BASIC-like scripting language.
     * 
     * <p>File extensions: {@code au3}</p>
     * 
     * @see <a href="https://www.autoitscript.com/site/">https://www.autoitscript.com/site/</a>
     */
    Autoit(
        "Autoit",
        "AutoIt v3 BASIC-like scripting language",
        "https://www.autoitscript.com/site/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("#comments-start|#cs"),
        new String[] {"au3"},
        new BlockDelimiter[] {new BlockDelimiter("#comments-start", "#comments-end"), new BlockDelimiter("#cs", "#ce")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * AutoHotkey task automation scripting language.
     * 
     * <p>File extensions: {@code ahk}</p>
     * 
     * @see <a href="https://www.autohotkey.com/">https://www.autohotkey.com/</a>
     */
    AutoHotKey(
        "AutoHotKey",
        "AutoHotkey task automation scripting language",
        "https://www.autohotkey.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*"),
        new String[] {"ahk"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * GNU Automake specification for generating Makefile.in.
     * 
     * <p>File extensions: {@code am}</p>
     * 
     * @see <a href="https://www.gnu.org/software/automake/">https://www.gnu.org/software/automake/</a>
     */
    Automake(
        "Automake",
        "GNU Automake specification for generating Makefile.in",
        "https://www.gnu.org/software/automake/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"am"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Avalonia UI XAML dialect.
     * 
     * <p>File extensions: {@code axaml}</p>
     * 
     * @see <a href="https://docs.avaloniaui.net/docs/basics/user-interface/introduction-to-xaml#axaml-file-extension">https://docs.avaloniaui.net/docs/basics/user-interface/introduction-to-xaml#axaml-file-extension</a>
     */
    Avalonia(
        "AXAML",
        "Avalonia UI XAML dialect",
        "https://docs.avaloniaui.net/docs/basics/user-interface/introduction-to-xaml#axaml-file-extension",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"axaml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Text processing script for AWK tool.
     * 
     * <p>File extensions: {@code awk}</p>
     * 
     * @see <a href="http://awklang.org/">http://awklang.org/</a>
     */
    AWK(
        "AWK",
        "Text processing script for AWK tool",
        "http://awklang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"awk"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Bourne Again SHell script.
     * 
     * <p>File extensions: {@code bash}</p>
     * 
     * @see <a href="https://www.gnu.org/software/bash/">https://www.gnu.org/software/bash/</a>
     */
    Bash(
        "BASH",
        "Bourne Again SHell script",
        "https://www.gnu.org/software/bash/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"bash"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Windows batch file.
     * 
     * <p>File extensions: {@code bat}, {@code btm}, {@code cmd}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands">https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands</a>
     */
    Batch(
        "Batch",
        "Windows batch file",
        "https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"bat", "btm", "cmd"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("REM") || predicate.test("rem") || predicate.test("Rem") || predicate.test("::");
        }

    },
    /**
     * Bazel build file.
     * 
     * <p>File extensions: {@code bzl}, {@code bazel}</p>
     * 
     * <p>File names: {@code build}, {@code workspace}</p>
     * @see <a href="https://bazel.build/">https://bazel.build/</a>
     */
    Bazel(
        "Bazel",
        "Bazel build file",
        "https://bazel.build/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        compile("\"|'|\"\"\"|'''"),
        new String[] {"bzl", "bazel"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Rich text and graphics file native to the Bean word processor.
     * 
     * <p>File extensions: {@code bean}, {@code beancount}</p>
     * 
     * @see <a href="https://www.bean-osx.com/Bean.html">https://www.bean-osx.com/Bean.html</a>
     */
    Bean(
        "Bean",
        "Rich text and graphics file native to the Bean word processor",
        "https://www.bean-osx.com/Bean.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"bean", "beancount"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * BitBake task execution script.
     * 
     * <p>File extensions: {@code bb}, {@code bbclass}, {@code bbappend}, {@code inc}</p>
     * 
     * @see <a href="https://docs.yoctoproject.org/bitbake/">https://docs.yoctoproject.org/bitbake/</a>
     */
    Bitbake(
        "Bitbake",
        "BitBake task execution script",
        "https://docs.yoctoproject.org/bitbake/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"bb", "bbclass", "bbappend", "inc"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Roku BrightScript scripting language.
     * 
     * <p>File extensions: {@code brs}</p>
     * 
     * @see <a href="https://developer.roku.com/docs/references/brightscript/language/brightscript-language-reference.md">https://developer.roku.com/docs/references/brightscript/language/brightscript-language-reference.md</a>
     */
    BrightScript(
        "BrightScript",
        "Roku BrightScript scripting language",
        "https://developer.roku.com/docs/references/brightscript/language/brightscript-language-reference.md",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"brs"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("'") || predicate.test("REM") || predicate.test("rem") || predicate.test("Rem");
        }

    },
    /**
     * C programming language.
     * 
     * <p>File extensions: {@code c}, {@code ec}, {@code pgc}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C_(programming_language)">https://en.wikipedia.org/wiki/C_(programming_language)</a>
     */
    C(
        "C",
        "C programming language",
        "https://en.wikipedia.org/wiki/C_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"c", "ec", "pgc"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Haskell build and packaging language.
     * 
     * <p>File extensions: {@code cabal}</p>
     * 
     * @see <a href="https://www.haskell.org/cabal/">https://www.haskell.org/cabal/</a>
     */
    Cabal(
        "Cabal",
        "Haskell build and packaging language",
        "https://www.haskell.org/cabal/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"cabal"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * CSS template language from the Shakespearean family of template languages.
     * 
     * <p>File extensions: {@code cassius}</p>
     * 
     * @see <a href="https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_cassius_css">https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_cassius_css</a>
     */
    Cassius(
        "Cassius",
        "CSS template language from the Shakespearean family of template languages",
        "https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_cassius_css",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"cassius"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Object-oriented, strongly statically typed programming language.
     * 
     * <p>File extensions: {@code ceylon}</p>
     * 
     * @see <a href="https://projects.eclipse.org/projects/technology.ceylon">https://projects.eclipse.org/projects/technology.ceylon</a>
     */
    Ceylon(
        "Ceylon",
        "Object-oriented, strongly statically typed programming language",
        "https://projects.eclipse.org/projects/technology.ceylon",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\"|/\\*"),
        new String[] {"ceylon"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("#!");
        }

    },
    /**
     * C programming language header file.
     * 
     * <p>File extensions: {@code h}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C_(programming_language)">https://en.wikipedia.org/wiki/C_(programming_language)</a>
     */
    CHeader(
        "C Header",
        "C programming language header file",
        "https://en.wikipedia.org/wiki/C_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"h"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Clojure programming language.
     * 
     * <p>File extensions: {@code clj}</p>
     * 
     * @see <a href="https://clojure.org/">https://clojure.org/</a>
     */
    Clojure(
        "Clojure",
        "Clojure programming language",
        "https://clojure.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"clj"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Clojure file for platform specific code.
     * 
     * <p>File extensions: {@code cljc}</p>
     * 
     * @see <a href="https://clojure.org/">https://clojure.org/</a>
     */
    ClojureC(
        "ClojureC",
        "Clojure file for platform specific code",
        "https://clojure.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"cljc"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Clojure scripting language file.
     * 
     * <p>File extensions: {@code cljs}</p>
     * 
     * @see <a href="https://clojurescript.org/">https://clojurescript.org/</a>
     */
    ClojureScript(
        "ClojureScript",
        "Clojure scripting language file",
        "https://clojurescript.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"cljs"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Build script for the CMake tool.
     * 
     * <p>File extensions: {@code cmake}</p>
     * 
     * <p>File names: {@code cmakelists.txt}</p>
     * @see <a href="https://cmake.org/">https://cmake.org/</a>
     */
    CMake(
        "CMake",
        "Build script for the CMake tool",
        "https://cmake.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"cmake"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * COmmon Business-Oriented Language.
     * 
     * <p>File extensions: {@code cob}, {@code cbl}, {@code ccp}, {@code cobol}, {@code cpy}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/COBOL">https://en.wikipedia.org/wiki/COBOL</a>
     */
    Cobol(
        "COBOL",
        "COmmon Business-Oriented Language",
        "https://en.wikipedia.org/wiki/COBOL",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"cob", "cbl", "ccp", "cobol", "cpy"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("*");
        }

    },
    /**
     * Code Query Language file.
     * 
     * <p>File extensions: {@code ql}, {@code qll}</p>
     * 
     * @see <a href="https://codeql.github.com/">https://codeql.github.com/</a>
     */
    CodeQL(
        "CodeQL",
        "Code Query Language file",
        "https://codeql.github.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ql", "qll"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * JavaScript-like scripting language.
     * 
     * <p>File extensions: {@code coffee}, {@code cjsx}</p>
     * 
     * @see <a href="https://coffeescript.org/">https://coffeescript.org/</a>
     */
    CoffeeScript(
        "CoffeeScript",
        "JavaScript-like scripting language",
        "https://coffeescript.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|###"),
        new String[] {"coffee", "cjsx"},
        new BlockDelimiter[] {new BlockDelimiter("###", "###")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Functional programming language.
     * 
     * <p>File extensions: {@code cogent}</p>
     * 
     * @see <a href="https://trustworthy.systems/projects/OLD/cogent/">https://trustworthy.systems/projects/OLD/cogent/</a>
     */
    Cogent(
        "Cogent",
        "Functional programming language",
        "https://trustworthy.systems/projects/OLD/cogent/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"cogent"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * ColdFusion Markup Language for web development.
     * 
     * <p>File extensions: {@code cfm}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/ColdFusion_Markup_Language">https://en.wikipedia.org/wiki/ColdFusion_Markup_Language</a>
     */
    ColdFusion(
        "ColdFusion",
        "ColdFusion Markup Language for web development",
        "https://en.wikipedia.org/wiki/ColdFusion_Markup_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!---"),
        new String[] {"cfm"},
        new BlockDelimiter[] {new BlockDelimiter("<!---", "--->")}
    ) {
    },
    /**
     * JavaScript-like extension of ColdFusion.
     * 
     * <p>File extensions: {@code cfc}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/CFScript">https://en.wikipedia.org/wiki/CFScript</a>
     */
    ColdFusionScript(
        "ColdFusion CFScript",
        "JavaScript-like extension of ColdFusion",
        "https://en.wikipedia.org/wiki/CFScript",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"cfc"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Interactive theorem prover language.
     * 
     * <p>File extensions: {@code v}</p>
     * 
     * @see <a href="https://coq.inria.fr/">https://coq.inria.fr/</a>
     */
    Coq(
        "Coq",
        "Interactive theorem prover language",
        "https://coq.inria.fr/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"v"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
    },
    /**
     * C++ programming language source file.
     * 
     * <p>File extensions: {@code cc}, {@code cpp}, {@code cxx}, {@code c++}, {@code pcc}, {@code tpp}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C%2B%2B">https://en.wikipedia.org/wiki/C%2B%2B</a>
     */
    Cpp(
        "C++",
        "C++ programming language source file",
        "https://en.wikipedia.org/wiki/C%2B%2B",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {new BlockDelimiter("R\"(", ")\"")},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"cc", "cpp", "cxx", "c++", "pcc", "tpp"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * C++ programming language header file.
     * 
     * <p>File extensions: {@code hh}, {@code hpp}, {@code hxx}, {@code inl}, {@code ipp}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C%2B%2B">https://en.wikipedia.org/wiki/C%2B%2B</a>
     */
    CppHeader(
        "C++ Header",
        "C++ programming language header file",
        "https://en.wikipedia.org/wiki/C%2B%2B",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"hh", "hpp", "hxx", "inl", "ipp"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Ruby-like programming language.
     * 
     * <p>File extensions: {@code cr}</p>
     * 
     * @see <a href="https://crystal-lang.org/">https://crystal-lang.org/</a>
     */
    Crystal(
        "Crystal",
        "Ruby-like programming language",
        "https://crystal-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"cr"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * C# programming language.
     * 
     * <p>File extensions: {@code cs}, {@code csx}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C_Sharp_(programming_language)">https://en.wikipedia.org/wiki/C_Sharp_(programming_language)</a>
     */
    CSharp(
        "C#",
        "C# programming language",
        "https://en.wikipedia.org/wiki/C_Sharp_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {new BlockDelimiter("@\"", "\"")},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"cs", "csx"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * C Shell scripting language.
     * 
     * <p>File extensions: {@code csh}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/C_shell">https://en.wikipedia.org/wiki/C_shell</a>
     */
    CShell(
        "C Shell",
        "C Shell scripting language",
        "https://en.wikipedia.org/wiki/C_shell",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"csh"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Cascading Style Sheets language.
     * 
     * <p>File extensions: {@code css}</p>
     * 
     * @see <a href="https://www.w3.org/Style/CSS/">https://www.w3.org/Style/CSS/</a>
     */
    Css(
        "CSS",
        "Cascading Style Sheets language",
        "https://www.w3.org/Style/CSS/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"css"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Compute Unified Device Architecture programming language.
     * 
     * <p>File extensions: {@code cu}</p>
     * 
     * @see <a href="https://developer.nvidia.com/cuda-zone">https://developer.nvidia.com/cuda-zone</a>
     */
    Cuda(
        "CUDA",
        "Compute Unified Device Architecture programming language",
        "https://developer.nvidia.com/cuda-zone",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"cu"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Superset of the Python programming language with C-like constructs.
     * 
     * <p>File extensions: {@code pyx}, {@code pxd}, {@code pxi}</p>
     * 
     * @see <a href="https://cython.org/">https://cython.org/</a>
     */
    Cython(
        "Cython",
        "Superset of the Python programming language with C-like constructs",
        "https://cython.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        compile("\"|'|\"\"\"|'''"),
        new String[] {"pyx", "pxd", "pxi"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * D programming language.
     * 
     * <p>File extensions: {@code d}</p>
     * 
     * @see <a href="https://dlang.org/">https://dlang.org/</a>
     */
    D(
        "D",
        "D programming language",
        "https://dlang.org/",
        new BlockDelimiter[] {new BlockDelimiter("/+", "+/")},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*|/\\+"),
        new String[] {"d"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/"), new BlockDelimiter("/+", "+/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public boolean isNestedComment(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.nestedComments.length; i++) {
                if (predicate.test(this.nestedComments[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * DARPA Agent Markup Language.
     * 
     * <p>File extensions: {@code daml}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/DARPA_Agent_Markup_Language">https://en.wikipedia.org/wiki/DARPA_Agent_Markup_Language</a>
     */
    Daml(
        "DAML",
        "DARPA Agent Markup Language",
        "https://en.wikipedia.org/wiki/DARPA_Agent_Markup_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"daml"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("-- ");
        }

    },
    /**
     * Dart programming language.
     * 
     * <p>File extensions: {@code dart}</p>
     * 
     * @see <a href="https://dart.dev/">https://dart.dev/</a>
     */
    Dart(
        "Dart",
        "Dart programming language",
        "https://dart.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|\"\"\"|'''|/\\*"),
        new String[] {"dart"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Device Tree source format.
     * 
     * <p>File extensions: {@code dts}, {@code dtsi}</p>
     * 
     * @see <a href="https://devicetree-specification.readthedocs.io/en/latest/">https://devicetree-specification.readthedocs.io/en/latest/</a>
     */
    DeviceTree(
        "Device Tree",
        "Device Tree source format",
        "https://devicetree-specification.readthedocs.io/en/latest/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"dts", "dtsi"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * JSON-like configuration language.
     * 
     * <p>File extensions: {@code dhall}</p>
     * 
     * @see <a href="https://dhall-lang.org/">https://dhall-lang.org/</a>
     */
    Dhall(
        "Dhall",
        "JSON-like configuration language",
        "https://dhall-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("''", "''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|''|\\{-"),
        new String[] {"dhall"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Docker configuration file.
     * 
     * <p>File extensions: {@code dockerfile}, {@code dockerignore}</p>
     * 
     * <p>File names: {@code dockerfile}</p>
     * @see <a href="https://docs.docker.com/engine/reference/builder/">https://docs.docker.com/engine/reference/builder/</a>
     */
    Dockerfile(
        "Dockerfile",
        "Docker configuration file",
        "https://docs.docker.com/engine/reference/builder/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"dockerfile", "dockerignore"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * .NET resource file.
     * 
     * <p>File extensions: {@code resx}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/dotnet/core/extensions/resources">https://learn.microsoft.com/en-us/dotnet/core/extensions/resources</a>
     */
    DotNetResource(
        ".NET Resource",
        ".NET resource file",
        "https://learn.microsoft.com/en-us/dotnet/core/extensions/resources",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|<!--"),
        new String[] {"resx"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Scripting language for the BYOND engine.
     * 
     * <p>File extensions: {@code dm}, {@code dme}</p>
     * 
     * @see <a href="https://www.byond.com/docs/guide/chap01.html">https://www.byond.com/docs/guide/chap01.html</a>
     */
    DreamMaker(
        "Dream Maker",
        "Scripting language for the BYOND engine",
        "https://www.byond.com/docs/guide/chap01.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("{\"", "\"}"), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\{\"|'|/\\*"),
        new String[] {"dm", "dme"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Document Style Semantics and Specification Language.
     * 
     * <p>File extensions: {@code dsl}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Document_Style_Semantics_and_Specification_Language">https://en.wikipedia.org/wiki/Document_Style_Semantics_and_Specification_Language</a>
     */
    Dsssl(
        "DSSSL",
        "Document Style Semantics and Specification Language",
        "https://en.wikipedia.org/wiki/Document_Style_Semantics_and_Specification_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {"dsl"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Defines the elements, attributes and text content allowed in an XML document.
     * 
     * <p>File extensions: {@code dtd}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Document_type_definition">https://en.wikipedia.org/wiki/Document_type_definition</a>
     */
    DTD(
        "Document Type Definition",
        "Defines the elements, attributes and text content allowed in an XML document",
        "https://en.wikipedia.org/wiki/Document_type_definition",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {"dtd"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * JavaScript template engine.
     * 
     * <p>File extensions: {@code dust}</p>
     * 
     * @see <a href="https://akdubya.github.io/dustjs/">https://akdubya.github.io/dustjs/</a>
     */
    Dust(
        "Dust.js",
        "JavaScript template engine",
        "https://akdubya.github.io/dustjs/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{!"),
        new String[] {"dust"},
        new BlockDelimiter[] {new BlockDelimiter("{!", "!}")}
    ) {
    },
    /**
     * Gentoo package manager description file.
     * 
     * <p>File extensions: {@code ebuild}, {@code eclass}</p>
     * 
     * @see <a href="https://wiki.gentoo.org/wiki/Ebuild">https://wiki.gentoo.org/wiki/Ebuild</a>
     */
    Ebuild(
        "Ebuild",
        "Gentoo package manager description file",
        "https://wiki.gentoo.org/wiki/Ebuild",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"ebuild", "eclass"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Database query language for EdgeDB.
     * 
     * <p>File extensions: {@code edgeql}</p>
     * 
     * @see <a href="https://www.edgedb.com/docs/edgeql/index">https://www.edgedb.com/docs/edgeql/index</a>
     */
    EdgeQL(
        "EdgeQL",
        "Database query language for EdgeDB",
        "https://www.edgedb.com/docs/edgeql/index",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'"), new BlockDelimiter("\"", "\""), new BlockDelimiter("$", "$")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("['\"$]"),
        new String[] {"edgeql"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * EdgeDB schema definition language.
     * 
     * <p>File extensions: {@code esdl}</p>
     * 
     * @see <a href="https://www.edgedb.com/docs/reference/sdl/index">https://www.edgedb.com/docs/reference/sdl/index</a>
     */
    ESDL(
        "EdgeDB Schema Definition",
        "EdgeDB schema definition language",
        "https://www.edgedb.com/docs/reference/sdl/index",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'"), new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("['\"]"),
        new String[] {"esdl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Extensible data notation.
     * 
     * <p>File extensions: {@code edn}</p>
     * 
     * @see <a href="https://github.com/edn-format/edn">https://github.com/edn-format/edn</a>
     */
    Edn(
        "Edn",
        "Extensible data notation",
        "https://github.com/edn-format/edn",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"edn"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Lisp dialect used by the Emacs editor.
     * 
     * <p>File extensions: {@code el}</p>
     * 
     * @see <a href="https://www.gnu.org/software/emacs/manual/html_node/elisp/">https://www.gnu.org/software/emacs/manual/html_node/elisp/</a>
     */
    Elisp(
        "Emacs Lisp",
        "Lisp dialect used by the Emacs editor",
        "https://www.gnu.org/software/emacs/manual/html_node/elisp/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"el"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Functional programming language.
     * 
     * <p>File extensions: {@code ex}, {@code exs}</p>
     * 
     * @see <a href="https://elixir-lang.org/">https://elixir-lang.org/</a>
     */
    Elixir(
        "Elixir",
        "Functional programming language",
        "https://elixir-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("\"", "\""), new BlockDelimiter("'''", "'''"), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("@moduledoc \"\"\"", "\"\"\""), new BlockDelimiter("@doc \"\"\"", "\"\"\"")},
        compile("\"\"\"|\"|'''|'|@moduledoc \"\"\"|@doc \"\"\""),
        new String[] {"ex", "exs"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Elm programming language.
     * 
     * <p>File extensions: {@code elm}</p>
     * 
     * @see <a href="https://elm-lang.org/">https://elm-lang.org/</a>
     */
    Elm(
        "Elm",
        "Elm programming language",
        "https://elm-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"elm"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Elvish programming language.
     * 
     * <p>File extensions: {@code elv}</p>
     * 
     * @see <a href="https://elv.sh/">https://elv.sh/</a>
     */
    Elvish(
        "Elvish",
        "Elvish programming language",
        "https://elv.sh/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"elv"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Emacs development environment.
     * 
     * <p>File extensions: {@code ede}</p>
     * 
     * @see <a href="https://www.gnu.org/software/emacs/manual/html_node/emacs/EDE.html">https://www.gnu.org/software/emacs/manual/html_node/emacs/EDE.html</a>
     */
    EmacsDevEnv(
        "Emacs Dev Env",
        "Emacs development environment",
        "https://www.gnu.org/software/emacs/manual/html_node/emacs/EDE.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"ede"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Programming language using emojis.
     * 
     * <p>File extensions: {@code emojic}, {@code \uD83C\uDF47}</p>
     * 
     * @see <a href="https://www.emojicode.org/">https://www.emojicode.org/</a>
     */
    Emojicode(
        "Emojicode",
        "Programming language using emojis",
        "https://www.emojicode.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\u274C\uD83D\uDD24", "\u274C\uD83D\uDD24")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\u274C\uD83D\uDD24|\uD83D\uDCAD\uD83D\uDD1C|\uD83D\uDCD7|\uD83D\uDCD8"),
        new String[] {"emojic", "\uD83C\uDF47"},
        new BlockDelimiter[] {new BlockDelimiter("\uD83D\uDCAD\uD83D\uDD1C", "\uD83D\uDD1A\uD83D\uDCAD"), new BlockDelimiter("\uD83D\uDCD7", "\uD83D\uDCD7"), new BlockDelimiter("\uD83D\uDCD8", "\uD83D\uDCD8")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("\uD83D\uDCAD");
        }

    },
    /**
     * Erlang programming language.
     * 
     * <p>File extensions: {@code erl}, {@code hrl}</p>
     * 
     * @see <a href="https://www.erlang.org/">https://www.erlang.org/</a>
     */
    Erlang(
        "Erlang",
        "Erlang programming language",
        "https://www.erlang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"erl", "hrl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%");
        }

    },
    /**
     * Application automation.
     * 
     * <p>File extensions: {@code exp}</p>
     * 
     * @see <a href="https://core.tcl-lang.org/expect/index">https://core.tcl-lang.org/expect/index</a>
     */
    Expect(
        "Expect",
        "Application automation",
        "https://core.tcl-lang.org/expect/index",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"exp"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Factor programming language.
     * 
     * <p>File extensions: {@code factor}</p>
     * 
     * @see <a href="https://factorcode.org/">https://factorcode.org/</a>
     */
    Factor(
        "Factor",
        "Factor programming language",
        "https://factorcode.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*"),
        new String[] {"factor"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("!") || predicate.test("#!");
        }

    },
    /**
     * Forsyth–Edwards Notation for describing board positions of a chess game.
     * 
     * <p>File extensions: {@code fen}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation">https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation</a>
     */
    FEN(
        "FEN",
        "Forsyth–Edwards Notation for describing board positions of a chess game",
        "https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"fen"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Fennel programming language.
     * 
     * <p>File extensions: {@code fnl}</p>
     * 
     * @see <a href="https://fennel-lang.org/">https://fennel-lang.org/</a>
     */
    Fennel(
        "Fennel",
        "Fennel programming language",
        "https://fennel-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"fnl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";") || predicate.test(";;");
        }

    },
    /**
     * Fish scripting language.
     * 
     * <p>File extensions: {@code fish}</p>
     * 
     * @see <a href="https://fishshell.com/docs/current/language.html">https://fishshell.com/docs/current/language.html</a>
     */
    Fish(
        "Fish",
        "Fish scripting language",
        "https://fishshell.com/docs/current/language.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"fish"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * FlatBuffers serialization library schema.
     * 
     * <p>File extensions: {@code fbs}</p>
     * 
     * @see <a href="https://flatbuffers.dev/">https://flatbuffers.dev/</a>
     */
    FlatBuffers(
        "FlatBuffers Schema",
        "FlatBuffers serialization library schema",
        "https://flatbuffers.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"fbs"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Minecraft Forge configuration file.
     * 
     * <p>File extensions: {@code cfg}</p>
     * 
     * @see <a href="https://forge.gemwire.uk/wiki/Configs">https://forge.gemwire.uk/wiki/Configs</a>
     */
    ForgeConfig(
        "Forge Config",
        "Minecraft Forge configuration file",
        "https://forge.gemwire.uk/wiki/Configs",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"cfg"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("~");
        }

    },
    /**
     * Forth programming language.
     * 
     * <p>File extensions: {@code 4th}, {@code forth}, {@code fr}, {@code frt}, {@code fth}, {@code f83}, {@code fb}, {@code fpm}, {@code e4}, {@code rx}, {@code ft}</p>
     * 
     * @see <a href="https://forth-standard.org/">https://forth-standard.org/</a>
     */
    Forth(
        "Forth",
        "Forth programming language",
        "https://forth-standard.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\( "),
        new String[] {"4th", "forth", "fr", "frt", "fth", "f83", "fb", "fpm", "e4", "rx", "ft"},
        new BlockDelimiter[] {new BlockDelimiter("( ", ")")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("\\");
        }

    },
    /**
     * FORTRAN programming language in its legacy format.
     * 
     * <p>File extensions: {@code f}, {@code for}, {@code ftn}, {@code f77}, {@code pfo}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Fortran">https://en.wikipedia.org/wiki/Fortran</a>
     */
    FortranLegacy(
        "FORTRAN Legacy",
        "FORTRAN programming language in its legacy format",
        "https://en.wikipedia.org/wiki/Fortran",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"f", "for", "ftn", "f77", "pfo"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isColumnSignificant() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("c") || predicate.test("C") || predicate.test("!") || predicate.test("*");
        }

    },
    /**
     * FORTRAN programming language in its modern format.
     * 
     * <p>File extensions: {@code f03}, {@code f08}, {@code f90}, {@code f95}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Fortran">https://en.wikipedia.org/wiki/Fortran</a>
     */
    FortranModern(
        "FORTRAN Modern",
        "FORTRAN programming language in its modern format",
        "https://en.wikipedia.org/wiki/Fortran",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"f03", "f08", "f90", "f95"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("!");
        }

    },
    /**
     * FreeMarker template language.
     * 
     * <p>File extensions: {@code ftl}, {@code ftlh}, {@code ftlx}</p>
     * 
     * @see <a href="https://freemarker.apache.org/">https://freemarker.apache.org/</a>
     */
    FreeMarker(
        "FreeMarker",
        "FreeMarker template language",
        "https://freemarker.apache.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<#--"),
        new String[] {"ftl", "ftlh", "ftlx"},
        new BlockDelimiter[] {new BlockDelimiter("<#--", "-->")}
    ) {
    },
    /**
     * F# programming language.
     * 
     * <p>File extensions: {@code fs}, {@code fsi}, {@code fsx}, {@code fsscript}</p>
     * 
     * @see <a href="https://fsharp.org/">https://fsharp.org/</a>
     */
    FSharp(
        "F#",
        "F# programming language",
        "https://fsharp.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {new BlockDelimiter("@\"", "\"")},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"fs", "fsi", "fsx", "fsscript"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * Proof-oriented programming language.
     * 
     * <p>File extensions: {@code fst}</p>
     * 
     * @see <a href="https://fstar-lang.org/">https://fstar-lang.org/</a>
     */
    Fstar(
        "F*",
        "Proof-oriented programming language",
        "https://fstar-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"fst"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Futhark programming language.
     * 
     * <p>File extensions: {@code fut}</p>
     * 
     * @see <a href="https://futhark-lang.org/">https://futhark-lang.org/</a>
     */
    Futhark(
        "Futhark",
        "Futhark programming language",
        "https://futhark-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"fut"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * GNU Project debugger script.
     * 
     * <p>File extensions: {@code gdb}</p>
     * 
     * @see <a href="https://www.sourceware.org/gdb/">https://www.sourceware.org/gdb/</a>
     */
    GDB(
        "GDB Script",
        "GNU Project debugger script",
        "https://www.sourceware.org/gdb/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"gdb"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Godot game engine scripting language.
     * 
     * <p>File extensions: {@code gd}</p>
     * 
     * @see <a href="https://gdscript.com/">https://gdscript.com/</a>
     */
    GdScript(
        "GDScript",
        "Godot game engine scripting language",
        "https://gdscript.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|\"\"\""),
        new String[] {"gd"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Cucumber scripting language.
     * 
     * <p>File extensions: {@code feature}</p>
     * 
     * @see <a href="https://cucumber.io/docs/gherkin/reference/">https://cucumber.io/docs/gherkin/reference/</a>
     */
    Gherkin(
        "Gherkin (Cucumber)",
        "Cucumber scripting language",
        "https://cucumber.io/docs/gherkin/reference/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"feature"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Functional programming language.
     * 
     * <p>File extensions: {@code gleam}</p>
     * 
     * @see <a href="https://gleam.run/">https://gleam.run/</a>
     */
    Gleam(
        "Gleam",
        "Functional programming language",
        "https://gleam.run/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"gleam"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("///") || predicate.test("////");
        }

    },
    /**
     * OpenGL Shading Language.
     * 
     * <p>File extensions: {@code vert}, {@code tesc}, {@code tese}, {@code geom}, {@code frag}, {@code comp}, {@code mesh}, {@code task}, {@code rgen}, {@code rint}, {@code rahit}, {@code rchit}, {@code rmiss}, {@code rcall}, {@code glsl}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/OpenGL_Shading_Language">https://en.wikipedia.org/wiki/OpenGL_Shading_Language</a>
     */
    Glsl(
        "GLSL",
        "OpenGL Shading Language",
        "https://en.wikipedia.org/wiki/OpenGL_Shading_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"vert", "tesc", "tese", "geom", "frag", "comp", "mesh", "task", "rgen", "rint", "rahit", "rchit", "rmiss", "rcall", "glsl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Geography Markup Language.
     * 
     * <p>File extensions: {@code gml}</p>
     * 
     * @see <a href="https://www.iso.org/standard/75676.html">https://www.iso.org/standard/75676.html</a>
     */
    Gml(
        "Gml",
        "Geography Markup Language",
        "https://www.iso.org/standard/75676.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"gml"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Go programming language.
     * 
     * <p>File extensions: {@code go}</p>
     * 
     * @see <a href="https://go.dev/">https://go.dev/</a>
     */
    Go(
        "Go",
        "Go programming language",
        "https://go.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"go"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Go template for generating HTML.
     * 
     * <p>File extensions: {@code gohtml}</p>
     * 
     * @see <a href="https://pkg.go.dev/html/template">https://pkg.go.dev/html/template</a>
     */
    Gohtml(
        "Go HTML",
        "Go template for generating HTML",
        "https://pkg.go.dev/html/template",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|\\{\\{/\\*"),
        new String[] {"gohtml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("{{/*", "*/}}")}
    ) {
    },
    /**
     * Gradle Kotlin build file.
     * 
     * 
     * <p>File names: {@code build.gradle.kts}, {@code settings.gradle.kts}</p>
     * @see <a href="https://gradle.org/">https://gradle.org/</a>
     */
    GradleKotlin(
        "GradleKotlin",
        "Gradle Kotlin build file",
        "https://gradle.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\"|/\\*"),
        new String[] {},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Gradle Groovy build file.
     * 
     * <p>File extensions: {@code gradle}</p>
     * 
     * @see <a href="https://gradle.org/">https://gradle.org/</a>
     */
    GradleGroovy(
        "GradleGroovy",
        "Gradle Groovy build file",
        "https://gradle.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"gradle"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Graph query language.
     * 
     * <p>File extensions: {@code gql}, {@code graphql}</p>
     * 
     * @see <a href="https://graphql.org/">https://graphql.org/</a>
     */
    Graphql(
        "GraphQL",
        "Graph query language",
        "https://graphql.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\""),
        new String[] {"gql", "graphql"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Groovy programming language.
     * 
     * <p>File extensions: {@code groovy}, {@code grt}, {@code gtpl}, {@code gvy}</p>
     * 
     * @see <a href="https://groovy-lang.org/">https://groovy-lang.org/</a>
     */
    Groovy(
        "Groovy",
        "Groovy programming language",
        "https://groovy-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"groovy", "grt", "gtpl", "gvy"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Gwion programming language.
     * 
     * <p>File extensions: {@code gw}</p>
     * 
     * @see <a href="https://gwion.github.io/Gwion/">https://gwion.github.io/Gwion/</a>
     */
    Gwion(
        "Gwion",
        "Gwion programming language",
        "https://gwion.github.io/Gwion/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"gw"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#!");
        }

    },
    /**
     * HTML abstraction markup language.
     * 
     * <p>File extensions: {@code haml}</p>
     * 
     * @see <a href="https://haml.info/">https://haml.info/</a>
     */
    Haml(
        "Haml",
        "HTML abstraction markup language",
        "https://haml.info/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"haml"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("-#");
        }

    },
    /**
     * HTML template language from the Shakespearean family of template languages.
     * 
     * <p>File extensions: {@code hamlet}</p>
     * 
     * @see <a href="https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_hamlet_html">https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_hamlet_html</a>
     */
    Hamlet(
        "Hamlet",
        "HTML template language from the Shakespearean family of template languages",
        "https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_hamlet_html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|<!--"),
        new String[] {"hamlet"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Handlebars template language.
     * 
     * <p>File extensions: {@code hbs}, {@code handlebars}</p>
     * 
     * @see <a href="https://handlebarsjs.com/">https://handlebarsjs.com/</a>
     */
    Handlebars(
        "Handlebars",
        "Handlebars template language",
        "https://handlebarsjs.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|\\{\\{!--|\\{\\{!"),
        new String[] {"hbs", "handlebars"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("{{!--", "--}}"), new BlockDelimiter("{{!", "}}")}
    ) {
    },
    /**
     * Haskell programming language.
     * 
     * <p>File extensions: {@code hs}</p>
     * 
     * @see <a href="https://www.haskell.org/">https://www.haskell.org/</a>
     */
    Haskell(
        "Haskell",
        "Haskell programming language",
        "https://www.haskell.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"hs"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Haxe programming language.
     * 
     * <p>File extensions: {@code hx}</p>
     * 
     * @see <a href="https://haxe.org/">https://haxe.org/</a>
     */
    Haxe(
        "Haxe",
        "Haxe programming language",
        "https://haxe.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"hx"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Hashicorp configuration language.
     * 
     * <p>File extensions: {@code hcl}, {@code tf}, {@code tfvars}</p>
     * 
     * @see <a href="https://github.com/hashicorp/hcl">https://github.com/hashicorp/hcl</a>
     */
    Hcl(
        "HCL",
        "Hashicorp configuration language",
        "https://github.com/hashicorp/hcl",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"hcl", "tf", "tfvars"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("//");
        }

    },
    /**
     * Headache programming language.
     * 
     * <p>File extensions: {@code ha}</p>
     * 
     * @see <a href="https://github.com/LucasMW/Headache">https://github.com/LucasMW/Headache</a>
     */
    Headache(
        "Headache",
        "Headache programming language",
        "https://github.com/LucasMW/Headache",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ha"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Identifier for the HICAD language.
     * 
     * <p>File extensions: {@code mac}</p>
     * 
     * 
     */
    HiCad(
        "HICAD",
        null,
        null,
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"mac"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("REM") || predicate.test("rem");
        }

    },
    /**
     * High Level Shader Language.
     * 
     * <p>File extensions: {@code hlsl}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/High-Level_Shader_Language">https://en.wikipedia.org/wiki/High-Level_Shader_Language</a>
     */
    Hlsl(
        "HLSL",
        "High Level Shader Language",
        "https://en.wikipedia.org/wiki/High-Level_Shader_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"hlsl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * C-like programming language used by TempleOS.
     * 
     * <p>File extensions: {@code hc}, {@code zc}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/TempleOS">https://en.wikipedia.org/wiki/TempleOS</a>
     */
    HolyC(
        "HolyC",
        "C-like programming language used by TempleOS",
        "https://en.wikipedia.org/wiki/TempleOS",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"hc", "zc"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * HyperText Markup Language.
     * 
     * <p>File extensions: {@code html}, {@code htm}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/HTML">https://en.wikipedia.org/wiki/HTML</a>
     */
    Html(
        "HTML",
        "HyperText Markup Language",
        "https://en.wikipedia.org/wiki/HTML",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|<script|<style|<template|<svg"),
        new String[] {"html", "htm"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.html;
        }
    },
    /**
     * Hy programming language.
     * 
     * <p>File extensions: {@code hy}</p>
     * 
     * @see <a href="https://hylang.org/">https://hylang.org/</a>
     */
    Hy(
        "Hy",
        "Hy programming language",
        "https://hylang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"hy"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Idris programming language.
     * 
     * <p>File extensions: {@code idr}, {@code lidr}</p>
     * 
     * @see <a href="https://www.idris-lang.org/">https://www.idris-lang.org/</a>
     */
    Idris(
        "Idris",
        "Idris programming language",
        "https://www.idris-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\"|\\{-"),
        new String[] {"idr", "lidr"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--") || predicate.test("|||");
        }

    },
    /**
     * INI configuration file.
     * 
     * <p>File extensions: {@code ini}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/INI_file">https://en.wikipedia.org/wiki/INI_file</a>
     */
    Ini(
        "INI",
        "INI configuration file",
        "https://en.wikipedia.org/wiki/INI_file",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"ini"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";") || predicate.test("#");
        }

    },
    /**
     * Intel hexadecimal object file format.
     * 
     * <p>File extensions: {@code hex}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Intel_HEX">https://en.wikipedia.org/wiki/Intel_HEX</a>
     */
    IntelHex(
        "Intel HEX",
        "Intel hexadecimal object file format",
        "https://en.wikipedia.org/wiki/Intel_HEX",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"hex"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Isabelle theorem prover language.
     * 
     * <p>File extensions: {@code thy}</p>
     * 
     * @see <a href="https://isabelle.in.tum.de/">https://isabelle.in.tum.de/</a>
     */
    Isabelle(
        "Isabelle",
        "Isabelle theorem prover language",
        "https://isabelle.in.tum.de/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("''", "''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("''|\\{\\*|\\(\\*|\u2039|\\<open>"),
        new String[] {"thy"},
        new BlockDelimiter[] {new BlockDelimiter("{*", "*}"), new BlockDelimiter("(*", "*)"), new BlockDelimiter("\u2039", "\u203A"), new BlockDelimiter("\\<open>", "\\<close>")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Jai programming language.
     * 
     * <p>File extensions: {@code jai}</p>
     * 
     * @see <a href="https://inductive.no/jai/">https://inductive.no/jai/</a>
     */
    Jai(
        "JAI",
        "Jai programming language",
        "https://inductive.no/jai/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"jai"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Java programming language.
     * 
     * <p>File extensions: {@code java}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">https://en.wikipedia.org/wiki/Java_(programming_language)</a>
     */
    Java(
        "Java",
        "Java programming language",
        "https://en.wikipedia.org/wiki/Java_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"java"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Java properties file.
     * 
     * <p>File extensions: {@code properties}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/.properties">https://en.wikipedia.org/wiki/.properties</a>
     */
    JavaProperties(
        "Java Properties",
        "Java properties file",
        "https://en.wikipedia.org/wiki/.properties",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"properties"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("!");
        }

    },
    /**
     * JavaScript programming language.
     * 
     * <p>File extensions: {@code cjs}, {@code js}, {@code mjs}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/JavaScript">https://en.wikipedia.org/wiki/JavaScript</a>
     */
    JavaScript(
        "JavaScript",
        "JavaScript programming language",
        "https://en.wikipedia.org/wiki/JavaScript",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|/\\*"),
        new String[] {"cjs", "js", "mjs"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Jinja template language.
     * 
     * <p>File extensions: {@code j2}</p>
     * 
     * @see <a href="https://palletsprojects.com/p/jinja/">https://palletsprojects.com/p/jinja/</a>
     */
    Jinja2(
        "Jinja2",
        "Jinja template language",
        "https://palletsprojects.com/p/jinja/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{#"),
        new String[] {"j2"},
        new BlockDelimiter[] {new BlockDelimiter("{#", "#}")}
    ) {
    },
    /**
     * JSON processing language.
     * 
     * <p>File extensions: {@code jq}</p>
     * 
     * @see <a href="https://jqlang.github.io/jq/">https://jqlang.github.io/jq/</a>
     */
    Jq(
        "jq",
        "JSON processing language",
        "https://jqlang.github.io/jq/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"jq"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * JavaScript Object Notation.
     * 
     * <p>File extensions: {@code json}</p>
     * 
     * @see <a href="https://www.json.org/json-en.html">https://www.json.org/json-en.html</a>
     */
    Json(
        "JSON",
        "JavaScript Object Notation",
        "https://www.json.org/json-en.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"json"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Jsonnet configuration language.
     * 
     * <p>File extensions: {@code jsonnet}, {@code libsonnet}</p>
     * 
     * @see <a href="https://jsonnet.org/">https://jsonnet.org/</a>
     */
    Jsonnet(
        "Jsonnet",
        "Jsonnet configuration language",
        "https://jsonnet.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"jsonnet", "libsonnet"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("#");
        }

    },
    /**
     * JavaScript XML specification of DOM trees using XML-like syntax.
     * 
     * <p>File extensions: {@code jsx}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/JSX_(JavaScript)">https://en.wikipedia.org/wiki/JSX_(JavaScript)</a>
     */
    Jsx(
        "JSX",
        "JavaScript XML specification of DOM trees using XML-like syntax",
        "https://en.wikipedia.org/wiki/JSX_(JavaScript)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|/\\*"),
        new String[] {"jsx"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Julia programming language.
     * 
     * <p>File extensions: {@code jl}</p>
     * 
     * @see <a href="https://julialang.org/">https://julialang.org/</a>
     */
    Julia(
        "Julia",
        "Julia programming language",
        "https://julialang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\"")},
        compile("\"|\"\"\"|#="),
        new String[] {"jl"},
        new BlockDelimiter[] {new BlockDelimiter("#=", "=#")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("\"");
        }

    },
    /**
     * JavaScript template language from the Shakespearean family of template languages.
     * 
     * <p>File extensions: {@code julius}</p>
     * 
     * @see <a href="https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_julius_javascript">https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_julius_javascript</a>
     */
    Julius(
        "Julius",
        "JavaScript template language from the Shakespearean family of template languages",
        "https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_julius_javascript",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|/\\*"),
        new String[] {"julius"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("--");
        }

    },
    /**
     * Jupyter Notebook content.
     * 
     * <p>File extensions: {@code ipynb}</p>
     * 
     * @see <a href="https://jupyter.org/">https://jupyter.org/</a>
     */
    Jupyter(
        "Jupyter Notebooks",
        "Jupyter Notebook content",
        "https://jupyter.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"ipynb"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Array processing programming language.
     * 
     * <p>File extensions: {@code k}</p>
     * 
     * @see <a href="https://kx.com/">https://kx.com/</a>
     */
    K(
        "K",
        "Array processing programming language",
        "https://kx.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"k"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("/");
        }

    },
    /**
     * Kakuone editor command script.
     * 
     * <p>File extensions: {@code kak}</p>
     * 
     * @see <a href="https://kakoune.org/">https://kakoune.org/</a>
     */
    KakouneScript(
        "Kakoune script",
        "Kakuone editor command script",
        "https://kakoune.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"kak"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Kotlin programming language.
     * 
     * <p>File extensions: {@code kt}, {@code kts}</p>
     * 
     * @see <a href="https://kotlinlang.org/">https://kotlinlang.org/</a>
     */
    Kotlin(
        "Kotlin",
        "Kotlin programming language",
        "https://kotlinlang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\"|/\\*"),
        new String[] {"kt", "kts"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Korn shell script.
     * 
     * <p>File extensions: {@code ksh}</p>
     * 
     * @see <a href="http://kornshell.com/">http://kornshell.com/</a>
     */
    Ksh(
        "Korn shell",
        "Korn shell script",
        "http://kornshell.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"ksh"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * KV programming language.
     * 
     * <p>File extensions: {@code kv}</p>
     * 
     * @see <a href="https://kivy.org/">https://kivy.org/</a>
     */
    KvLanguage(
        "KV Language",
        "KV programming language",
        "https://kivy.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        compile("\"|'|\"\"\"|'''"),
        new String[] {"kv"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("# ");
        }

    },
    /**
     * Lean proof assistant and programming language.
     * 
     * <p>File extensions: {@code lean}, {@code hlean}</p>
     * 
     * @see <a href="https://lean-lang.org/">https://lean-lang.org/</a>
     */
    Lean(
        "Lean",
        "Lean proof assistant and programming language",
        "https://lean-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/-"),
        new String[] {"lean", "hlean"},
        new BlockDelimiter[] {new BlockDelimiter("/-", "-/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * LEaner Style Sheet language.
     * 
     * <p>File extensions: {@code less}</p>
     * 
     * @see <a href="https://lesscss.org/">https://lesscss.org/</a>
     */
    Less(
        "LESS",
        "LEaner Style Sheet language",
        "https://lesscss.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"less"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Liquid template language.
     * 
     * <p>File extensions: {@code liquid}</p>
     * 
     * @see <a href="https://shopify.github.io/liquid/">https://shopify.github.io/liquid/</a>
     */
    Liquid(
        "Liquid",
        "Liquid template language",
        "https://shopify.github.io/liquid/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|\\{% comment %\\}|\\{% schema %\\}|\\{% javascript %\\}|\\{% stylesheet %\\}"),
        new String[] {"liquid"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("{% comment %}", "{% endcomment %}")}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.liquid;
        }
    },
    /**
     * Linker command script.
     * 
     * <p>File extensions: {@code ld}, {@code lds}</p>
     * 
     * @see <a href="https://sourceware.org/binutils/docs/ld/Scripts.html">https://sourceware.org/binutils/docs/ld/Scripts.html</a>
     */
    LinkerScript(
        "LD Script",
        "Linker command script",
        "https://sourceware.org/binutils/docs/ld/Scripts.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ld", "lds"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
    },
    /**
     * List processing language.
     * 
     * <p>File extensions: {@code lisp}, {@code lsp}, {@code asd}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Lisp_(programming_language)">https://en.wikipedia.org/wiki/Lisp_(programming_language)</a>
     */
    Lisp(
        "Common Lisp",
        "List processing language",
        "https://en.wikipedia.org/wiki/Lisp_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("#\\|"),
        new String[] {"lisp", "lsp", "asd"},
        new BlockDelimiter[] {new BlockDelimiter("#|", "|#")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * LiveScript scripting language.
     * 
     * <p>File extensions: {@code ls}</p>
     * 
     * @see <a href="https://livescript.net/">https://livescript.net/</a>
     */
    LiveScript(
        "LiveScript",
        "LiveScript scripting language",
        "https://livescript.net/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"ls"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Human readable LLVM intermediate representation file.
     * 
     * <p>File extensions: {@code ll}</p>
     * 
     * @see <a href="https://llvm.org/">https://llvm.org/</a>
     */
    LLVM(
        "LLVM",
        "Human readable LLVM intermediate representation file",
        "https://llvm.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"ll"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Logtalk programming language.
     * 
     * <p>File extensions: {@code lgt}, {@code logtalk}</p>
     * 
     * @see <a href="https://logtalk.org/">https://logtalk.org/</a>
     */
    Logtalk(
        "Logtalk",
        "Logtalk programming language",
        "https://logtalk.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"lgt", "logtalk"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%");
        }

    },
    /**
     * LOLCODE esoteric programming language.
     * 
     * <p>File extensions: {@code lol}</p>
     * 
     * @see <a href="http://www.lolcode.org/">http://www.lolcode.org/</a>
     */
    LolCode(
        "LOLCODE",
        "LOLCODE esoteric programming language",
        "http://www.lolcode.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|OBTW"),
        new String[] {"lol"},
        new BlockDelimiter[] {new BlockDelimiter("OBTW", "TLDR")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("BTW");
        }

    },
    /**
     * Lua programming language.
     * 
     * <p>File extensions: {@code lua}</p>
     * 
     * @see <a href="https://www.lua.org/">https://www.lua.org/</a>
     */
    Lua(
        "Lua",
        "Lua programming language",
        "https://www.lua.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|--\\[\\["),
        new String[] {"lua"},
        new BlockDelimiter[] {new BlockDelimiter("--[[", "]]")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * CSS template language from the Shakespearean family of template languages.
     * 
     * <p>File extensions: {@code lucius}</p>
     * 
     * @see <a href="https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_lucius_css">https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_lucius_css</a>
     */
    Lucius(
        "Lucius",
        "CSS template language from the Shakespearean family of template languages",
        "https://www.yesodweb.com/book/shakespearean-templates#shakespearean-templates_lucius_css",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"lucius"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Macro processing language.
     * 
     * <p>File extensions: {@code m4}</p>
     * 
     * @see <a href="https://www.gnu.org/software/m4/m4.html">https://www.gnu.org/software/m4/m4.html</a>
     */
    M4(
        "M4",
        "Macro processing language",
        "https://www.gnu.org/software/m4/m4.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("`", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("`"),
        new String[] {"m4"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("dnl");
        }

    },
    /**
     * Random text generation language.
     * 
     * <p>File extensions: {@code mad}</p>
     * 
     * @see <a href="https://github.com/vmchale/madlang">https://github.com/vmchale/madlang</a>
     */
    Madlang(
        "Madlang",
        "Random text generation language",
        "https://github.com/vmchale/madlang",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{#"),
        new String[] {"mad"},
        new BlockDelimiter[] {new BlockDelimiter("{#", "#}")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Build configuration file for the make tool.
     * 
     * <p>File extensions: {@code makefile}, {@code mak}, {@code mk}</p>
     * 
     * <p>File names: {@code makefile}</p>
     * @see <a href="https://en.wikipedia.org/wiki/Make_(software)">https://en.wikipedia.org/wiki/Make_(software)</a>
     */
    Makefile(
        "Makefile",
        "Build configuration file for the make tool",
        "https://en.wikipedia.org/wiki/Make_(software)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"makefile", "mak", "mk"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Document markup language.
     * 
     * <p>File extensions: {@code md}, {@code markdown}</p>
     * 
     * @see <a href="https://daringfireball.net/projects/markdown/">https://daringfireball.net/projects/markdown/</a>
     */
    Markdown(
        "Markdown",
        "Document markup language",
        "https://daringfireball.net/projects/markdown/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("```"),
        new String[] {"md", "markdown"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.markdown;
        }
    },
    /**
     * Diagram markup language.
     * 
     * <p>File extensions: {@code mmd}, {@code mermaid}</p>
     * 
     * @see <a href="https://mermaid.js.org/">https://mermaid.js.org/</a>
     */
    Mermaid(
        "Mermaid",
        "Diagram markup language",
        "https://mermaid.js.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"mmd", "mermaid"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%% ");
        }

    },
    /**
     * Meson build configuration language.
     * 
     * 
     * <p>File names: {@code meson.build}, {@code meson_options.txt}</p>
     * @see <a href="https://mesonbuild.com/">https://mesonbuild.com/</a>
     */
    Meson(
        "Meson",
        "Meson build configuration language",
        "https://mesonbuild.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'"), new BlockDelimiter("'''", "'''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("'|'''"),
        new String[] {},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Metal shader API by Apple.
     * 
     * <p>File extensions: {@code metal}</p>
     * 
     * @see <a href="https://developer.apple.com/metal/">https://developer.apple.com/metal/</a>
     */
    Metal(
        "Metal Shading Language",
        "Metal shader API by Apple",
        "https://developer.apple.com/metal/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"metal"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Mint programming language.
     * 
     * <p>File extensions: {@code mint}</p>
     * 
     * @see <a href="https://mint-lang.com/">https://mint-lang.com/</a>
     */
    Mint(
        "Mint",
        "Mint programming language",
        "https://mint-lang.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"mint"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Declarative and concatenative programming language.
     * 
     * <p>File extensions: {@code mlt}</p>
     * 
     * @see <a href="https://github.com/mlatu-lang/mlatu">https://github.com/mlatu-lang/mlatu</a>
     */
    Mlatu(
        "Mlatu",
        "Declarative and concatenative programming language",
        "https://github.com/mlatu-lang/mlatu",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"mlt"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Linker information file.
     * 
     * <p>File extensions: {@code def}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/cpp/build/reference/module-definition-dot-def-files?view=msvc-170">https://learn.microsoft.com/en-us/cpp/build/reference/module-definition-dot-def-files?view=msvc-170</a>
     */
    ModuleDef(
        "Module-Definition",
        "Linker information file",
        "https://learn.microsoft.com/en-us/cpp/build/reference/module-definition-dot-def-files?view=msvc-170",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"def"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * MoonScript scripting language.
     * 
     * <p>File extensions: {@code moon}</p>
     * 
     * @see <a href="https://moonscript.org/">https://moonscript.org/</a>
     */
    MoonScript(
        "MoonScript",
        "MoonScript scripting language",
        "https://moonscript.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"moon"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Visual Studio project files.
     * 
     * <p>File extensions: {@code csproj}, {@code vbproj}, {@code fsproj}, {@code props}, {@code targets}</p>
     * 
     * @see <a href="https://github.com/dotnet/msbuild">https://github.com/dotnet/msbuild</a>
     */
    MsBuild(
        "MSBuild",
        "Visual Studio project files",
        "https://github.com/dotnet/msbuild",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"csproj", "vbproj", "fsproj", "props", "targets"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Logic-less template language.
     * 
     * <p>File extensions: {@code mustache}</p>
     * 
     * @see <a href="https://mustache.github.io/">https://mustache.github.io/</a>
     */
    Mustache(
        "Mustache",
        "Logic-less template language",
        "https://mustache.github.io/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\{\\{!"),
        new String[] {"mustache"},
        new BlockDelimiter[] {new BlockDelimiter("{{!", "}}")}
    ) {
    },
    /**
     * Extension to the Groovy programming language.
     * 
     * <p>File extensions: {@code nextflow}, {@code nf}</p>
     * 
     * @see <a href="https://www.nextflow.io/">https://www.nextflow.io/</a>
     */
    Nextflow(
        "Nextflow",
        "Extension to the Groovy programming language",
        "https://www.nextflow.io/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"nextflow", "nf"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Nim programming language.
     * 
     * <p>File extensions: {@code nim}</p>
     * 
     * @see <a href="https://nim-lang.org/">https://nim-lang.org/</a>
     */
    Nim(
        "Nim",
        "Nim programming language",
        "https://nim-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("\"\"\"", "\"\"\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\"\"\""),
        new String[] {"nim"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Nix programming language.
     * 
     * <p>File extensions: {@code nix}</p>
     * 
     * @see <a href="https://nix.dev/">https://nix.dev/</a>
     */
    Nix(
        "Nix",
        "Nix programming language",
        "https://nix.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("''", "''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|''|/\\*"),
        new String[] {"nix"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Subset of the Perl programming language.
     * 
     * <p>File extensions: {@code nqp}</p>
     * 
     * @see <a href="https://en.wikibooks.org/wiki/Parrot_Virtual_Machine/Not_Quite_Perl">https://en.wikibooks.org/wiki/Parrot_Virtual_Machine/Not_Quite_Perl</a>
     */
    NotQuitePerl(
        "Not Quite Perl",
        "Subset of the Perl programming language",
        "https://en.wikibooks.org/wiki/Parrot_Virtual_Machine/Not_Quite_Perl",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|=begin"),
        new String[] {"nqp"},
        new BlockDelimiter[] {new BlockDelimiter("=begin", "=end")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * NuGet configuration file.
     * 
     * 
     * <p>File names: {@code nuget.config}, {@code packages.config}, {@code nugetdefaults.config}</p>
     * @see <a href="https://learn.microsoft.com/en-us/nuget/reference/nuget-config-file">https://learn.microsoft.com/en-us/nuget/reference/nuget-config-file</a>
     */
    NuGetConfig(
        "NuGet Config",
        "NuGet configuration file",
        "https://learn.microsoft.com/en-us/nuget/reference/nuget-config-file",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Nushell shell language.
     * 
     * <p>File extensions: {@code nu}</p>
     * 
     * @see <a href="https://www.nushell.sh/">https://www.nushell.sh/</a>
     */
    Nushell(
        "Nushell",
        "Nushell shell language",
        "https://www.nushell.sh/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"nu"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Objective-C programming language.
     * 
     * <p>File extensions: {@code m}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Objective-C">https://en.wikipedia.org/wiki/Objective-C</a>
     */
    ObjectiveC(
        "Objective-C",
        "Objective-C programming language",
        "https://en.wikipedia.org/wiki/Objective-C",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"m"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Objective-C variant allowing C++ constructs.
     * 
     * <p>File extensions: {@code mm}</p>
     * 
     * @see <a href="https://stackoverflow.com/questions/3684112/what-is-objective-c">https://stackoverflow.com/questions/3684112/what-is-objective-c</a>
     */
    ObjectiveCpp(
        "Objective-C++",
        "Objective-C variant allowing C++ constructs",
        "https://stackoverflow.com/questions/3684112/what-is-objective-c",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"mm"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * OCaml programming language.
     * 
     * <p>File extensions: {@code ml}, {@code mli}, {@code mll}, {@code mly}, {@code re}, {@code rei}</p>
     * 
     * @see <a href="https://ocaml.org/">https://ocaml.org/</a>
     */
    OCaml(
        "OCaml",
        "OCaml programming language",
        "https://ocaml.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"ml", "mli", "mll", "mly", "re", "rei"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
    },
    /**
     * Odin programming language.
     * 
     * <p>File extensions: {@code odin}</p>
     * 
     * @see <a href="https://odin-lang.org/">https://odin-lang.org/</a>
     */
    Odin(
        "Odin",
        "Odin programming language",
        "https://odin-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"odin"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Open Policy Agent language.
     * 
     * <p>File extensions: {@code rego}</p>
     * 
     * @see <a href="https://www.openpolicyagent.org/docs/latest/">https://www.openpolicyagent.org/docs/latest/</a>
     */
    OpenPolicyAgent(
        "Open Policy Agent",
        "Open Policy Agent language",
        "https://www.openpolicyagent.org/docs/latest/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"`]"),
        new String[] {"rego"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * OpenType feature typographic layout file.
     * 
     * <p>File extensions: {@code fea}</p>
     * 
     * @see <a href="https://adobe-type-tools.github.io/afdko/OpenTypeFeatureFileSpecification.html">https://adobe-type-tools.github.io/afdko/OpenTypeFeatureFileSpecification.html</a>
     */
    OpenType(
        "OpenType Feature File",
        "OpenType feature typographic layout file",
        "https://adobe-type-tools.github.io/afdko/OpenTypeFeatureFileSpecification.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"fea"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Org markup language.
     * 
     * <p>File extensions: {@code org}</p>
     * 
     * @see <a href="https://orgmode.org/">https://orgmode.org/</a>
     */
    Org(
        "Org",
        "Org markup language",
        "https://orgmode.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"org"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("# ");
        }

    },
    /**
     * Oz programming language.
     * 
     * <p>File extensions: {@code oz}</p>
     * 
     * @see <a href="http://mozart2.org/">http://mozart2.org/</a>
     */
    Oz(
        "Oz",
        "Oz programming language",
        "http://mozart2.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"oz"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%");
        }

    },
    /**
     * Shell script to build Arch Linux packages.
     * 
     * 
     * <p>File names: {@code pkgbuild}</p>
     * @see <a href="https://wiki.archlinux.org/title/PKGBUILD">https://wiki.archlinux.org/title/PKGBUILD</a>
     */
    PacmanMakepkg(
        "Pacman's makepkg",
        "Shell script to build Arch Linux packages",
        "https://wiki.archlinux.org/title/PKGBUILD",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Pan configuration language.
     * 
     * <p>File extensions: {@code pan}, {@code tpl}</p>
     * 
     * @see <a href="https://github.com/quattor/pan">https://github.com/quattor/pan</a>
     */
    Pan(
        "Pan",
        "Pan configuration language",
        "https://github.com/quattor/pan",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"pan", "tpl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Pascal programming language.
     * 
     * <p>File extensions: {@code pas}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Pascal_(programming_language)">https://en.wikipedia.org/wiki/Pascal_(programming_language)</a>
     */
    Pascal(
        "Pascal",
        "Pascal programming language",
        "https://en.wikipedia.org/wiki/Pascal_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("'|\\{|\\(\\*"),
        new String[] {"pas"},
        new BlockDelimiter[] {new BlockDelimiter("{", "}"), new BlockDelimiter("(*", "*)")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Perl programming language.
     * 
     * <p>File extensions: {@code pl}, {@code pm}</p>
     * 
     * @see <a href="https://www.perl.org/">https://www.perl.org/</a>
     */
    Perl(
        "Perl",
        "Perl programming language",
        "https://www.perl.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|=pod"),
        new String[] {"pl", "pm"},
        new BlockDelimiter[] {new BlockDelimiter("=pod", "=cut")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Pest expression grammar file.
     * 
     * <p>File extensions: {@code pest}</p>
     * 
     * @see <a href="https://pest.rs/">https://pest.rs/</a>
     */
    Pest(
        "Pest",
        "Pest expression grammar file",
        "https://pest.rs/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"pest"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * PHP scripting language.
     * 
     * <p>File extensions: {@code php}</p>
     * 
     * @see <a href="https://www.php.net/">https://www.php.net/</a>
     */
    Php(
        "PHP",
        "PHP scripting language",
        "https://www.php.net/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"php"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("//");
        }

    },
    /**
     * Poke binary data editor file.
     * 
     * <p>File extensions: {@code pk}</p>
     * 
     * @see <a href="https://www.jemarch.net/poke">https://www.jemarch.net/poke</a>
     */
    Poke(
        "Poke",
        "Poke binary data editor file",
        "https://www.jemarch.net/poke",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*"),
        new String[] {"pk"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
    },
    /**
     * Maven Project Object Model build file.
     * 
     * 
     * <p>File names: {@code pom.xml}</p>
     * @see <a href="https://maven.apache.org/pom.html">https://maven.apache.org/pom.html</a>
     */
    POM(
        "Maven POM",
        "Maven Project Object Model build file",
        "https://maven.apache.org/pom.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Pony programming language.
     * 
     * <p>File extensions: {@code pony}</p>
     * 
     * @see <a href="https://www.ponylang.io/">https://www.ponylang.io/</a>
     */
    Pony(
        "Pony",
        "Pony programming language",
        "https://www.ponylang.io/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\"")},
        compile("\"|\"\"\"|/\\*"),
        new String[] {"pony"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * CSS processing language.
     * 
     * <p>File extensions: {@code pcss}, {@code sss}</p>
     * 
     * @see <a href="https://postcss.org/">https://postcss.org/</a>
     */
    PostCss(
        "PostCSS",
        "CSS processing language",
        "https://postcss.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"pcss", "sss"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Cross platform task automation shell.
     * 
     * <p>File extensions: {@code ps1}, {@code psm1}, {@code psd1}, {@code ps1xml}, {@code cdxml}, {@code pssc}, {@code psc1}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/powershell/">https://learn.microsoft.com/en-us/powershell/</a>
     */
    PowerShell(
        "PowerShell",
        "Cross platform task automation shell",
        "https://learn.microsoft.com/en-us/powershell/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("\"@", "@\""), new BlockDelimiter("@'", "'@")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|\"@|@'|<#"),
        new String[] {"ps1", "psm1", "psd1", "ps1xml", "cdxml", "pssc", "psc1"},
        new BlockDelimiter[] {new BlockDelimiter("<#", "#>")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Processing software sketchbook and  language for learning how to code.
     * 
     * <p>File extensions: {@code pde}</p>
     * 
     * @see <a href="https://processing.org/">https://processing.org/</a>
     */
    Processing(
        "Processing",
        "Processing software sketchbook and  language for learning how to code",
        "https://processing.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"pde"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Prolog programming language.
     * 
     * <p>File extensions: {@code p}, {@code pro}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Prolog">https://en.wikipedia.org/wiki/Prolog</a>
     */
    Prolog(
        "Prolog",
        "Prolog programming language",
        "https://en.wikipedia.org/wiki/Prolog",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"p", "pro"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%");
        }

    },
    /**
     * Property specification language.
     * 
     * <p>File extensions: {@code psl}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Property_Specification_Language">https://en.wikipedia.org/wiki/Property_Specification_Language</a>
     */
    PSL(
        "PSL Assertion",
        "Property specification language",
        "https://en.wikipedia.org/wiki/Property_Specification_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"psl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Protocol Buffers interface definition language.
     * 
     * <p>File extensions: {@code proto}</p>
     * 
     * @see <a href="https://protobuf.dev/">https://protobuf.dev/</a>
     */
    Protobuf(
        "Protocol Buffers",
        "Protocol Buffers interface definition language",
        "https://protobuf.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"proto"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Pug programming language.
     * 
     * <p>File extensions: {@code pug}</p>
     * 
     * @see <a href="https://pugjs.org">https://pugjs.org</a>
     */
    Pug(
        "Pug",
        "Pug programming language",
        "https://pugjs.org",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("#{\"", "\"}"), new BlockDelimiter("#{'", "'}"), new BlockDelimiter("#{`", "`}")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("#\\{\"|#\\{'|#\\{`"),
        new String[] {"pug"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("//-");
        }

    },
    /**
     * Puppet infrastructure configuration language.
     * 
     * <p>File extensions: {@code pp}</p>
     * 
     * @see <a href="https://www.puppet.com/">https://www.puppet.com/</a>
     */
    Puppet(
        "Puppet",
        "Puppet infrastructure configuration language",
        "https://www.puppet.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"pp"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * PureScript functional programming language.
     * 
     * <p>File extensions: {@code purs}</p>
     * 
     * @see <a href="https://www.purescript.org/">https://www.purescript.org/</a>
     */
    PureScript(
        "PureScript",
        "PureScript functional programming language",
        "https://www.purescript.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\{-"),
        new String[] {"purs"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Python programming language.
     * 
     * <p>File extensions: {@code py}, {@code pyw}</p>
     * 
     * @see <a href="https://www.python.org/">https://www.python.org/</a>
     */
    Python(
        "Python",
        "Python programming language",
        "https://www.python.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        compile("\"|'|\"\"\"|'''"),
        new String[] {"py", "pyw"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Q array processing language.
     * 
     * <p>File extensions: {@code q}</p>
     * 
     * @see <a href="https://kx.com/">https://kx.com/</a>
     */
    Q(
        "Q",
        "Q array processing language",
        "https://kx.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"q"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("/");
        }

    },
    /**
     * Quantum Computing Language.
     * 
     * <p>File extensions: {@code qcl}</p>
     * 
     * @see <a href="https://github.com/aviggiano/qcl">https://github.com/aviggiano/qcl</a>
     */
    Qcl(
        "QCL",
        "Quantum Computing Language",
        "https://github.com/aviggiano/qcl",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"qcl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Qt Modeling Language.
     * 
     * <p>File extensions: {@code qml}</p>
     * 
     * @see <a href="https://doc.qt.io/qt-5/qmlreference.html">https://doc.qt.io/qt-5/qmlreference.html</a>
     */
    Qml(
        "QML",
        "Qt Modeling Language",
        "https://doc.qt.io/qt-5/qmlreference.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"qml"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Statistical computing language.
     * 
     * <p>File extensions: {@code r}</p>
     * 
     * @see <a href="https://www.r-project.org/">https://www.r-project.org/</a>
     */
    R(
        "R",
        "Statistical computing language",
        "https://www.r-project.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"r"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Racket programming language.
     * 
     * <p>File extensions: {@code rkt}, {@code scrbl}</p>
     * 
     * @see <a href="https://racket-lang.org/">https://racket-lang.org/</a>
     */
    Racket(
        "Racket",
        "Racket programming language",
        "https://racket-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("#\\|"),
        new String[] {"rkt", "scrbl"},
        new BlockDelimiter[] {new BlockDelimiter("#|", "|#")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * Ruby build configuration file.
     * 
     * <p>File extensions: {@code rake}</p>
     * 
     * <p>File names: {@code rakefile}</p>
     * @see <a href="https://ruby.github.io/rake/doc/rakefile_rdoc.html">https://ruby.github.io/rake/doc/rakefile_rdoc.html</a>
     */
    Rakefile(
        "Rakefile",
        "Ruby build configuration file",
        "https://ruby.github.io/rake/doc/rakefile_rdoc.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|=begin"),
        new String[] {"rake"},
        new BlockDelimiter[] {new BlockDelimiter("=begin", "=end")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Raku programming language.
     * 
     * <p>File extensions: {@code raku}, {@code rakumod}, {@code rakutest}, {@code pm6}, {@code pl6}, {@code p6}</p>
     * 
     * @see <a href="https://raku.org/">https://raku.org/</a>
     */
    Raku(
        "Raku",
        "Raku programming language",
        "https://raku.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {new BlockDelimiter("\uFF62", "\uFF63")},
        new BlockDelimiter[] {new BlockDelimiter("#|{", "}"), new BlockDelimiter("#={", "}"), new BlockDelimiter("#|(", ")"), new BlockDelimiter("#=(", ")"), new BlockDelimiter("#|[", "]"), new BlockDelimiter("#=[", "]"), new BlockDelimiter("#|\uFF62", "\uFF63"), new BlockDelimiter("#=\uFF62", "\uFF63"), new BlockDelimiter("=begin pod", "=end pod"), new BlockDelimiter("=begin code", "=end code"), new BlockDelimiter("=begin head", "=end head"), new BlockDelimiter("=begin item", "=end item"), new BlockDelimiter("=begin table", "=end table"), new BlockDelimiter("=begin defn", "=end defn"), new BlockDelimiter("=begin para", "=end para"), new BlockDelimiter("=begin comment", "=end comment"), new BlockDelimiter("=begin data", "=end data"), new BlockDelimiter("=begin DESCRIPTION", "=end DESCRIPTION"), new BlockDelimiter("=begin SYNOPSIS", "=end SYNOPSIS"), new BlockDelimiter("=begin ", "=end ")},
        compile("\"|'|#\\|\\{|#=\\{|#\\|\\(|#=\\(|#\\|\\[|#=\\[|#\\|\uFF62|#=\uFF62|=begin pod|=begin code|=begin head|=begin item|=begin table|=begin defn|=begin para|=begin comment|=begin data|=begin DESCRIPTION|=begin SYNOPSIS|=begin |#`\\(|#`\\[|#`\\{|#`\uFF62"),
        new String[] {"raku", "rakumod", "rakutest", "pm6", "pl6", "p6"},
        new BlockDelimiter[] {new BlockDelimiter("#`(", ")"), new BlockDelimiter("#`[", "]"), new BlockDelimiter("#`{", "}"), new BlockDelimiter("#`\uFF62", "\uFF63")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * Razor markup language for embedding .NET based code into webpages.
     * 
     * <p>File extensions: {@code cshtml}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/aspnet/core/mvc/views/razor?view=aspnetcore-8.0">https://learn.microsoft.com/en-us/aspnet/core/mvc/views/razor?view=aspnetcore-8.0</a>
     */
    Razor(
        "Razor",
        "Razor markup language for embedding .NET based code into webpages",
        "https://learn.microsoft.com/en-us/aspnet/core/mvc/views/razor?view=aspnetcore-8.0",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--|@\\*"),
        new String[] {"cshtml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("@*", "*@")}
    ) {
    },
    /**
     * Redscript programming language.
     * 
     * <p>File extensions: {@code reds}</p>
     * 
     * @see <a href="https://wiki.redmodding.org/redscript/">https://wiki.redmodding.org/redscript/</a>
     */
    Redscript(
        "Redscript",
        "Redscript programming language",
        "https://wiki.redmodding.org/redscript/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"reds"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("///");
        }

    },
    /**
     * Visual novel engine file.
     * 
     * <p>File extensions: {@code rpy}</p>
     * 
     * @see <a href="https://www.renpy.org/">https://www.renpy.org/</a>
     */
    Renpy(
        "Ren'Py",
        "Visual novel engine file",
        "https://www.renpy.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"'`]"),
        new String[] {"rpy"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * ReScript programming language.
     * 
     * <p>File extensions: {@code res}, {@code resi}</p>
     * 
     * @see <a href="https://rescript-lang.org/">https://rescript-lang.org/</a>
     */
    ReScript(
        "ReScript",
        "ReScript programming language",
        "https://rescript-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"res", "resi"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * reStructuredText markup language for technical documentation.
     * 
     * <p>File extensions: {@code rst}</p>
     * 
     * @see <a href="https://docutils.sourceforge.io/rst.html">https://docutils.sourceforge.io/rst.html</a>
     */
    ReStructuredText(
        "ReStructuredText",
        "reStructuredText markup language for technical documentation",
        "https://docutils.sourceforge.io/rst.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"rst"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * RON data serialization format.
     * 
     * <p>File extensions: {@code ron}</p>
     * 
     * @see <a href="https://github.com/ron-rs/ron">https://github.com/ron-rs/ron</a>
     */
    RON(
        "Rusty Object Notation",
        "RON data serialization format",
        "https://github.com/ron-rs/ron",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ron"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * RedHat Package Manager configuration file.
     * 
     * <p>File extensions: {@code spec}</p>
     * 
     * @see <a href="https://rpm-software-management.github.io/rpm/manual/spec.html">https://rpm-software-management.github.io/rpm/manual/spec.html</a>
     */
    RPMSpecfile(
        "RPM Specfile",
        "RedHat Package Manager configuration file",
        "https://rpm-software-management.github.io/rpm/manual/spec.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"spec"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Ruby programming language.
     * 
     * <p>File extensions: {@code rb}</p>
     * 
     * @see <a href="https://www.ruby-lang.org/">https://www.ruby-lang.org/</a>
     */
    Ruby(
        "Ruby",
        "Ruby programming language",
        "https://www.ruby-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|=begin"),
        new String[] {"rb"},
        new BlockDelimiter[] {new BlockDelimiter("=begin", "=end")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Ruby template language.
     * 
     * <p>File extensions: {@code rhtml}, {@code erb}</p>
     * 
     * @see <a href="https://www.rubyguides.com/2018/11/ruby-erb-haml-slim/">https://www.rubyguides.com/2018/11/ruby-erb-haml-slim/</a>
     */
    RubyHtml(
        "Ruby HTML",
        "Ruby template language",
        "https://www.rubyguides.com/2018/11/ruby-erb-haml-slim/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|<script|<style"),
        new String[] {"rhtml", "erb"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.html;
        }
    },
    /**
     * Rust programming language.
     * 
     * <p>File extensions: {@code rs}</p>
     * 
     * @see <a href="https://www.rust-lang.org/">https://www.rust-lang.org/</a>
     */
    Rust(
        "Rust",
        "Rust programming language",
        "https://www.rust-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("#\"", "\"#")},
        new BlockDelimiter[] {new BlockDelimiter("r##\"", "\"##"), new BlockDelimiter("r#\"", "\"#")},
        new BlockDelimiter[] {},
        compile("\"|#\"|/\\*|///|//!"),
        new String[] {"rs"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.rust;
        }
    },
    /**
     * Syntactically Awesome Style Sheets.
     * 
     * <p>File extensions: {@code sass}, {@code scss}</p>
     * 
     * @see <a href="https://sass-lang.com/">https://sass-lang.com/</a>
     */
    Sass(
        "Sass",
        "Syntactically Awesome Style Sheets",
        "https://sass-lang.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"sass", "scss"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Scala programming language.
     * 
     * <p>File extensions: {@code sc}, {@code scala}</p>
     * 
     * @see <a href="https://www.scala-lang.org/">https://www.scala-lang.org/</a>
     */
    Scala(
        "Scala",
        "Scala programming language",
        "https://www.scala-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"sc", "scala"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Scheme dialect of the Lisp programming language.
     * 
     * <p>File extensions: {@code scm}, {@code ss}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Scheme_(programming_language)">https://en.wikipedia.org/wiki/Scheme_(programming_language)</a>
     */
    Scheme(
        "Scheme",
        "Scheme dialect of the Lisp programming language",
        "https://en.wikipedia.org/wiki/Scheme_(programming_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("#\\|"),
        new String[] {"scm", "ss"},
        new BlockDelimiter[] {new BlockDelimiter("#|", "|#")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";");
        }

    },
    /**
     * SCons build configuration file.
     * 
     * 
     * <p>File names: {@code sconstruct}, {@code sconscript}</p>
     * @see <a href="https://scons.org/">https://scons.org/</a>
     */
    Scons(
        "Scons",
        "SCons build configuration file",
        "https://scons.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|\"\"\"|'''"),
        new String[] {},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Stream editor script.
     * 
     * <p>File extensions: {@code sed}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Sed">https://en.wikipedia.org/wiki/Sed</a>
     */
    Sed(
        "Sed",
        "Stream editor script",
        "https://en.wikipedia.org/wiki/Sed",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"sed"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Standard Generalized Markup Language.
     * 
     * <p>File extensions: {@code sgml}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Standard_Generalized_Markup_Language">https://en.wikipedia.org/wiki/Standard_Generalized_Markup_Language</a>
     */
    Sgml(
        "Sgml",
        "Standard Generalized Markup Language",
        "https://en.wikipedia.org/wiki/Standard_Generalized_Markup_Language",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {"sgml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Bourne shell command interpreter.
     * 
     * <p>File extensions: {@code sh}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Bourne_shell">https://en.wikipedia.org/wiki/Bourne_shell</a>
     */
    Sh(
        "Shell",
        "Bourne shell command interpreter",
        "https://en.wikipedia.org/wiki/Bourne_shell",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"sh"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * ShaderLab declarative language.
     * 
     * <p>File extensions: {@code shader}, {@code cginc}</p>
     * 
     * @see <a href="https://docs.unity3d.com/Manual/SL-Reference.html">https://docs.unity3d.com/Manual/SL-Reference.html</a>
     */
    ShaderLab(
        "ShaderLab",
        "ShaderLab declarative language",
        "https://docs.unity3d.com/Manual/SL-Reference.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"shader", "cginc"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Declarative GUI layout.
     * 
     * <p>File extensions: {@code slint}</p>
     * 
     * @see <a href="https://slint.dev/">https://slint.dev/</a>
     */
    Slint(
        "Slint",
        "Declarative GUI layout",
        "https://slint.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\\\"", "\\\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\\\"|/\\*"),
        new String[] {"slint"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Standard Meta Language programming language.
     * 
     * <p>File extensions: {@code sml}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Standard_ML">https://en.wikipedia.org/wiki/Standard_ML</a>
     */
    Sml(
        "Standard ML (SML)",
        "Standard Meta Language programming language",
        "https://en.wikipedia.org/wiki/Standard_ML",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"sml"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
    },
    /**
     * Smalltalk programming language.
     * 
     * <p>File extensions: {@code st}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Smalltalk">https://en.wikipedia.org/wiki/Smalltalk</a>
     */
    Smalltalk(
        "Smalltalk",
        "Smalltalk programming language",
        "https://en.wikipedia.org/wiki/Smalltalk",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("['\"]"),
        new String[] {"st"},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")}
    ) {
    },
    /**
     * Solidity programming language.
     * 
     * <p>File extensions: {@code sol}</p>
     * 
     * @see <a href="https://soliditylang.org/">https://soliditylang.org/</a>
     */
    Solidity(
        "Solidity",
        "Solidity programming language",
        "https://soliditylang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"sol"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Specman e hardware verification language.
     * 
     * <p>File extensions: {@code e}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/E_(verification_language)">https://en.wikipedia.org/wiki/E_(verification_language)</a>
     */
    SpecmanE(
        "Specman e",
        "Specman e hardware verification language",
        "https://en.wikipedia.org/wiki/E_(verification_language)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("'>"),
        new String[] {"e"},
        new BlockDelimiter[] {new BlockDelimiter("'>", "<'")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--") || predicate.test("//");
        }

    },
    /**
     * Simulation Program with Integrated Circuit Emphasis analog electronic circuit simulation language.
     * 
     * <p>File extensions: {@code ckt}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/SPICE">https://en.wikipedia.org/wiki/SPICE</a>
     */
    Spice(
        "Spice Netlist",
        "Simulation Program with Integrated Circuit Emphasis analog electronic circuit simulation language",
        "https://en.wikipedia.org/wiki/SPICE",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"ckt"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("*");
        }

    },
    /**
     * Structured Query Language.
     * 
     * <p>File extensions: {@code sql}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/SQL">https://en.wikipedia.org/wiki/SQL</a>
     */
    Sql(
        "SQL",
        "Structured Query Language",
        "https://en.wikipedia.org/wiki/SQL",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("'|/\\*"),
        new String[] {"sql"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Status Quo Function programming language.
     * 
     * <p>File extensions: {@code sqf}</p>
     * 
     * @see <a href="https://community.bistudio.com/wiki/SQF_Syntax">https://community.bistudio.com/wiki/SQF_Syntax</a>
     */
    Sqf(
        "SQF",
        "Status Quo Function programming language",
        "https://community.bistudio.com/wiki/SQF_Syntax",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"sqf"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Semantic Recoder template file.
     * 
     * <p>File extensions: {@code srt}</p>
     * 
     * @see <a href="https://www.gnu.org/software/emacs/manual/html_mono/srecode.html">https://www.gnu.org/software/emacs/manual/html_mono/srecode.html</a>
     */
    SRecode(
        "SRecode Template",
        "Semantic Recoder template file",
        "https://www.gnu.org/software/emacs/manual/html_mono/srecode.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"srt"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";;");
        }

    },
    /**
     * Statistical modelling and computation language.
     * 
     * <p>File extensions: {@code stan}</p>
     * 
     * @see <a href="https://mc-stan.org/">https://mc-stan.org/</a>
     */
    Stan(
        "Stan",
        "Statistical modelling and computation language",
        "https://mc-stan.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"stan"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("#");
        }

    },
    /**
     * Program manipulation language.
     * 
     * <p>File extensions: {@code str}</p>
     * 
     * @see <a href="https://strategoxt.org/">https://strategoxt.org/</a>
     */
    Stratego(
        "Stratego/XT",
        "Program manipulation language",
        "https://strategoxt.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("$[", "]"), new BlockDelimiter("$<", ">"), new BlockDelimiter("${", "}")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\$\\[|\\$<|\\$\\{|/\\*"),
        new String[] {"str"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * CSS language for Node.js.
     * 
     * <p>File extensions: {@code styl}</p>
     * 
     * @see <a href="https://stylus-lang.com/">https://stylus-lang.com/</a>
     */
    Stylus(
        "Stylus",
        "CSS language for Node.js",
        "https://stylus-lang.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"styl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Svelte web framework language.
     * 
     * <p>File extensions: {@code svelte}</p>
     * 
     * @see <a href="https://svelte.dev/">https://svelte.dev/</a>
     */
    Svelte(
        "Svelte",
        "Svelte web framework language",
        "https://svelte.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|<script|<style|<template"),
        new String[] {"svelte"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.html;
        }
    },
    /**
     * Scalable Vector Graphics.
     * 
     * <p>File extensions: {@code svg}</p>
     * 
     * @see <a href="https://www.w3.org/Graphics/SVG/">https://www.w3.org/Graphics/SVG/</a>
     */
    Svg(
        "SVG",
        "Scalable Vector Graphics",
        "https://www.w3.org/Graphics/SVG/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"svg"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Swift programming language.
     * 
     * <p>File extensions: {@code swift}</p>
     * 
     * @see <a href="https://www.swift.org/">https://www.swift.org/</a>
     */
    Swift(
        "Swift",
        "Swift programming language",
        "https://www.swift.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"swift"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Simplified Wrapper and Interface Generator.
     * 
     * <p>File extensions: {@code swg}, {@code i}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/SWIG">https://en.wikipedia.org/wiki/SWIG</a>
     */
    Swig(
        "SWIG",
        "Simplified Wrapper and Interface Generator",
        "https://en.wikipedia.org/wiki/SWIG",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"swg", "i"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * IEEE 1800 hardware description and verification language.
     * 
     * <p>File extensions: {@code sv}, {@code svh}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/SystemVerilog">https://en.wikipedia.org/wiki/SystemVerilog</a>
     */
    SystemVerilog(
        "SystemVerilog",
        "IEEE 1800 hardware description and verification language",
        "https://en.wikipedia.org/wiki/SystemVerilog",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"sv", "svh"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Tcl programming language.
     * 
     * <p>File extensions: {@code tcl}</p>
     * 
     * @see <a href="https://www.tcl.tk/">https://www.tcl.tk/</a>
     */
    Tcl(
        "TCL",
        "Tcl programming language",
        "https://www.tcl.tk/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"tcl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Rust template engine.
     * 
     * <p>File extensions: {@code tera}</p>
     * 
     * @see <a href="https://keats.github.io/tera/">https://keats.github.io/tera/</a>
     */
    Tera(
        "Tera",
        "Rust template engine",
        "https://keats.github.io/tera/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|\\{#"),
        new String[] {"tera"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("{#", "#}")}
    ) {
    },
    /**
     * TeX typesetting file.
     * 
     * <p>File extensions: {@code tex}, {@code sty}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/TeX">https://en.wikipedia.org/wiki/TeX</a>
     */
    Tex(
        "TeX",
        "TeX typesetting file",
        "https://en.wikipedia.org/wiki/TeX",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"tex", "sty"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("%");
        }

    },
    /**
     * Plain text file.
     * 
     * <p>File extensions: {@code text}, {@code txt}</p>
     * 
     * 
     */
    Text(
        "Plain Text",
        "Plain text file",
        null,
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"text", "txt"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Apache Thrift interface definition language.
     * 
     * <p>File extensions: {@code thrift}</p>
     * 
     * @see <a href="https://thrift.apache.org/">https://thrift.apache.org/</a>
     */
    Thrift(
        "Thrift",
        "Apache Thrift interface definition language",
        "https://thrift.apache.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"thrift"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#") || predicate.test("//");
        }

    },
    /**
     * Tom's Obvious Minimal Language.
     * 
     * <p>File extensions: {@code toml}</p>
     * 
     * @see <a href="https://toml.io/en/">https://toml.io/en/</a>
     */
    Toml(
        "TOML",
        "Tom's Obvious Minimal Language",
        "https://toml.io/en/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("\"\"\"", "\"\"\""), new BlockDelimiter("'''", "'''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|\"\"\"|'''"),
        new String[] {"toml"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Declarative, XML-like user interface definition language.
     * 
     * <p>File extensions: {@code tsx}</p>
     * 
     * @see <a href="https://electricui.com/docs/interface/ui-language#tsx">https://electricui.com/docs/interface/ui-language#tsx</a>
     */
    Tsx(
        "TSX",
        "Declarative, XML-like user interface definition language",
        "https://electricui.com/docs/interface/ui-language#tsx",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|/\\*"),
        new String[] {"tsx"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * TTCN programming language.
     * 
     * <p>File extensions: {@code ttcn}, {@code ttcn3}, {@code ttcnpp}</p>
     * 
     * @see <a href="http://www.ttcn-3.org/">http://www.ttcn-3.org/</a>
     */
    Ttcn(
        "TTCN-3",
        "TTCN programming language",
        "http://www.ttcn-3.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ttcn", "ttcn3", "ttcnpp"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * PHP template language.
     * 
     * <p>File extensions: {@code twig}</p>
     * 
     * @see <a href="https://twig.symfony.com/">https://twig.symfony.com/</a>
     */
    Twig(
        "Twig",
        "PHP template language",
        "https://twig.symfony.com/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--|\\{#"),
        new String[] {"twig"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("{#", "#}")}
    ) {
    },
    /**
     * JavaScript with strong typing.
     * 
     * <p>File extensions: {@code ts}</p>
     * 
     * @see <a href="https://www.typescriptlang.org/">https://www.typescriptlang.org/</a>
     */
    TypeScript(
        "TypeScript",
        "JavaScript with strong typing",
        "https://www.typescriptlang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|/\\*"),
        new String[] {"ts"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * UMPL is a highly verbose, both c and lisp-like language.
     * 
     * <p>File extensions: {@code umpl}</p>
     * 
     * @see <a href="https://github.com/mendelsshop/UMPL">https://github.com/mendelsshop/UMPL</a>
     */
    UMPL(
        "UMPL",
        "UMPL is a highly verbose, both c and lisp-like language",
        "https://github.com/mendelsshop/UMPL",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("`"),
        new String[] {"umpl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("!");
        }

    },
    /**
     * Inison programming language.
     * 
     * <p>File extensions: {@code u}</p>
     * 
     * @see <a href="https://www.unison-lang.org/">https://www.unison-lang.org/</a>
     */
    Unison(
        "Unison",
        "Inison programming language",
        "https://www.unison-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\{-"),
        new String[] {"u"},
        new BlockDelimiter[] {new BlockDelimiter("{-", "-}")}
    ) {
        @Override
        public boolean isNestable() {
            return true;
        }

        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Unreal Engine development markdown language.
     * 
     * <p>File extensions: {@code udn}</p>
     * 
     * @see <a href="https://github.com/raysjoshua/UnrealEngine/blob/master/Engine/Documentation/Source/DocumentationGuidelines/DocumentationGuidelines.INT.udn">https://github.com/raysjoshua/UnrealEngine/blob/master/Engine/Documentation/Source/DocumentationGuidelines/DocumentationGuidelines.INT.udn</a>
     */
    UnrealDeveloperMarkdown(
        "Unreal Markdown",
        "Unreal Engine development markdown language",
        "https://github.com/raysjoshua/UnrealEngine/blob/master/Engine/Documentation/Source/DocumentationGuidelines/DocumentationGuidelines.INT.udn",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("```"),
        new String[] {"udn"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.markdown;
        }
    },
    /**
     * Unreal Engine plugin descriptor.
     * 
     * <p>File extensions: {@code uplugin}</p>
     * 
     * @see <a href="https://docs.unrealengine.com/5.0/en-US/plugins-in-unreal-engine/">https://docs.unrealengine.com/5.0/en-US/plugins-in-unreal-engine/</a>
     */
    UnrealPlugin(
        "Unreal Plugin",
        "Unreal Engine plugin descriptor",
        "https://docs.unrealengine.com/5.0/en-US/plugins-in-unreal-engine/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"uplugin"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Unreal Engine project file.
     * 
     * <p>File extensions: {@code uproject}</p>
     * 
     * @see <a href="https://docs.unrealengine.com/4.26/en-US/Basics/Projects/">https://docs.unrealengine.com/4.26/en-US/Basics/Projects/</a>
     */
    UnrealProject(
        "Unreal Project",
        "Unreal Engine project file",
        "https://docs.unrealengine.com/4.26/en-US/Basics/Projects/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"uproject"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * Unreal Engine script.
     * 
     * <p>File extensions: {@code uc}, {@code uci}, {@code upkg}</p>
     * 
     * @see <a href="https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/">https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/</a>
     */
    UnrealScript(
        "Unreal Script",
        "Unreal Engine script",
        "https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"uc", "uci", "upkg"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Unreal Engine shader source file.
     * 
     * <p>File extensions: {@code usf}</p>
     * 
     * @see <a href="https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/">https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/</a>
     */
    UnrealShader(
        "Unreal Shader",
        "Unreal Engine shader source file",
        "https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"usf"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Unreal Engine shader header file.
     * 
     * <p>File extensions: {@code ush}</p>
     * 
     * @see <a href="https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/">https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/</a>
     */
    UnrealShaderHeader(
        "Unreal Shader Header",
        "Unreal Engine shader header file",
        "https://docs.unrealengine.com/4.26/en-US/ProgrammingAndScripting/Rendering/ShaderDevelopment/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"ush"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Ur/Web functional programming language.
     * 
     * <p>File extensions: {@code ur}, {@code urs}</p>
     * 
     * @see <a href="http://impredicative.com/ur/">http://impredicative.com/ur/</a>
     */
    UrWeb(
        "Ur/Web",
        "Ur/Web functional programming language",
        "http://impredicative.com/ur/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"ur", "urs"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
    },
    /**
     * Ur/Web project file.
     * 
     * <p>File extensions: {@code urp}</p>
     * 
     * @see <a href="https://github.com/urweb/urweb">https://github.com/urweb/urweb</a>
     */
    UrWebProject(
        "Ur/Web Project",
        "Ur/Web project file",
        "https://github.com/urweb/urweb",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"urp"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Vala programming language.
     * 
     * <p>File extensions: {@code vala}</p>
     * 
     * @see <a href="https://vala.dev/">https://vala.dev/</a>
     */
    Vala(
        "Vala",
        "Vala programming language",
        "https://vala.dev/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"vala"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Visual Basic 6.
     * 
     * <p>File extensions: {@code frm}, {@code bas}, {@code cls}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/visual-basic-6.0-documentation">https://learn.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/visual-basic-6.0-documentation</a>
     */
    VB6(
        "VB6",
        "Visual Basic 6",
        "https://learn.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/visual-basic-6.0-documentation",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"frm", "bas", "cls"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("'");
        }

    },
    /**
     * Visual Basic Script.
     * 
     * <p>File extensions: {@code vbs}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/previous-versions/windows/internet-explorer/ie-developer/scripting-articles/d1wf56tt(v=vs.84)">https://learn.microsoft.com/en-us/previous-versions/windows/internet-explorer/ie-developer/scripting-articles/d1wf56tt(v=vs.84)</a>
     */
    VBScript(
        "VBScript",
        "Visual Basic Script",
        "https://learn.microsoft.com/en-us/previous-versions/windows/internet-explorer/ie-developer/scripting-articles/d1wf56tt(v=vs.84)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"vbs"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("'") || predicate.test("REM");
        }

    },
    /**
     * Java-based template language.
     * 
     * <p>File extensions: {@code vm}, {@code vtl}</p>
     * 
     * @see <a href="https://velocity.apache.org/">https://velocity.apache.org/</a>
     */
    Velocity(
        "Apache Velocity",
        "Java-based template language",
        "https://velocity.apache.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("'", "'"), new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("'|\"|#\\*"),
        new String[] {"vm", "vtl"},
        new BlockDelimiter[] {new BlockDelimiter("#*", "*#")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("##");
        }

    },
    /**
     * Verilog (IEEE 1364) hardware description language.
     * 
     * <p>File extensions: {@code vg}, {@code vh}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Verilog">https://en.wikipedia.org/wiki/Verilog</a>
     */
    Verilog(
        "Verilog",
        "Verilog (IEEE 1364) hardware description language",
        "https://en.wikipedia.org/wiki/Verilog",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|/\\*"),
        new String[] {"vg", "vh"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * File containing command-line arguments to the Verilog irun or xrun program.
     * 
     * <p>File extensions: {@code irunargs}, {@code xrunargs}</p>
     * 
     * 
     */
    VerilogArgsFile(
        "Verilog Args File",
        "File containing command-line arguments to the Verilog irun or xrun program",
        null,
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"irunargs", "xrunargs"},
        new BlockDelimiter[] {}
    ) {
    },
    /**
     * VHSIC Hardware Description Language hardware description language.
     * 
     * <p>File extensions: {@code vhd}, {@code vhdl}</p>
     * 
     * @see <a href="https://www.vhdl.org/">https://www.vhdl.org/</a>
     */
    Vhdl(
        "VHDL",
        "VHSIC Hardware Description Language hardware description language",
        "https://www.vhdl.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("/\\*"),
        new String[] {"vhd", "vhdl"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("--");
        }

    },
    /**
     * Visual Basic programming language.
     * 
     * <p>File extensions: {@code vb}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Visual_Basic_(classic)">https://en.wikipedia.org/wiki/Visual_Basic_(classic)</a>
     */
    VisualBasic(
        "Visual Basic",
        "Visual Basic programming language",
        "https://en.wikipedia.org/wiki/Visual_Basic_(classic)",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"vb"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("'");
        }

    },
    /**
     * Visual Studio project file.
     * 
     * <p>File extensions: {@code vcproj}, {@code vcxproj}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/projects">https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/projects</a>
     */
    VisualStudioProject(
        "Visual Studio Project",
        "Visual Studio project file",
        "https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/projects",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"vcproj", "vcxproj"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Visual Studio solution file.
     * 
     * <p>File extensions: {@code sln}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/solution-dot-sln-file">https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/solution-dot-sln-file</a>
     */
    VisualStudioSolution(
        "Visual Studio Solution",
        "Visual Studio solution file",
        "https://learn.microsoft.com/en-us/visualstudio/extensibility/internals/solution-dot-sln-file",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"sln"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * Voice interaction markup language.
     * 
     * <p>File extensions: {@code vxml}</p>
     * 
     * @see <a href="https://www.w3.org/TR/voicexml21/">https://www.w3.org/TR/voicexml21/</a>
     */
    VoiceXml(
        "Voice XML",
        "Voice interaction markup language",
        "https://www.w3.org/TR/voicexml21/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {"vxml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Vue web framework file.
     * 
     * <p>File extensions: {@code vue}</p>
     * 
     * @see <a href="https://vuejs.org/">https://vuejs.org/</a>
     */
    Vue(
        "Vue",
        "Vue web framework file",
        "https://vuejs.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("`", "`")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|`|<!--|/\\*|<script|<style|<template"),
        new String[] {"vue"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->"), new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

        @Override
        public Embedding.Syntax getEmbedSyntax() {
            return Embedding.Syntax.html;
        }
    },
    /**
     * WebAssembly text format.
     * 
     * <p>File extensions: {@code wat}, {@code wast}</p>
     * 
     * @see <a href="https://www.webassemblyman.com/wat_webassembly_text_format.html">https://www.webassemblyman.com/wat_webassembly_text_format.html</a>
     */
    WebAssembly(
        "WebAssembly",
        "WebAssembly text format",
        "https://www.webassemblyman.com/wat_webassembly_text_format.html",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"wat", "wast"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test(";;");
        }

    },
    /**
     * Esoteric programming language closely following the grammar and tone of classical Chinese literature.
     * 
     * <p>File extensions: {@code wy}</p>
     * 
     * @see <a href="https://wy-lang.org/">https://wy-lang.org/</a>
     */
    WenYan(
        "The WenYan Programming Language",
        "Esoteric programming language closely following the grammar and tone of classical Chinese literature",
        "https://wy-lang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\u6279\u66F0\u3002|\u758F\u66F0\u3002"),
        new String[] {"wy"},
        new BlockDelimiter[] {new BlockDelimiter("\u6279\u66F0\u3002", "\u3002"), new BlockDelimiter("\u758F\u66F0\u3002", "\u3002")}
    ) {
    },
    /**
     * WebGPU Shading Language.
     * 
     * <p>File extensions: {@code wgsl}</p>
     * 
     * @see <a href="https://www.w3.org/TR/WGSL/">https://www.w3.org/TR/WGSL/</a>
     */
    WGSL(
        "WebGPU Shader Language",
        "WebGPU Shading Language",
        "https://www.w3.org/TR/WGSL/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        null,
        new String[] {"wgsl"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Wolfram symbolic programming language.
     * 
     * <p>File extensions: {@code nb}, {@code wl}</p>
     * 
     * @see <a href="https://www.wolfram.com/language/">https://www.wolfram.com/language/</a>
     */
    Wolfram(
        "Wolfram",
        "Wolfram symbolic programming language",
        "https://www.wolfram.com/language/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|\\(\\*"),
        new String[] {"nb", "wl"},
        new BlockDelimiter[] {new BlockDelimiter("(*", "*)")}
    ) {
    },
    /**
     * Extensible Application Markup Language.
     * 
     * <p>File extensions: {@code xaml}</p>
     * 
     * @see <a href="https://learn.microsoft.com/en-us/dotnet/desktop/xaml-services/?redirectedfrom=MSDN">https://learn.microsoft.com/en-us/dotnet/desktop/xaml-services/?redirectedfrom=MSDN</a>
     */
    Xaml(
        "XAML",
        "Extensible Application Markup Language",
        "https://learn.microsoft.com/en-us/dotnet/desktop/xaml-services/?redirectedfrom=MSDN",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"xaml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Xcode IDE configuration file.
     * 
     * <p>File extensions: {@code xcconfig}</p>
     * 
     * @see <a href="https://developer.apple.com/xcode/">https://developer.apple.com/xcode/</a>
     */
    XcodeConfig(
        "Xcode Config",
        "Xcode IDE configuration file",
        "https://developer.apple.com/xcode/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"xcconfig"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Extensible Markup Language.
     * 
     * <p>File extensions: {@code xml}</p>
     * 
     * @see <a href="https://www.w3.org/XML/">https://www.w3.org/XML/</a>
     */
    Xml(
        "XML",
        "Extensible Markup Language",
        "https://www.w3.org/XML/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("<!--"),
        new String[] {"xml"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Extensible Stylesheet Language.
     * 
     * <p>File extensions: {@code xsl}, {@code xslt}</p>
     * 
     * @see <a href="https://www.w3.org/Style/XSL/">https://www.w3.org/Style/XSL/</a>
     */
    XSL(
        "XSL",
        "Extensible Stylesheet Language",
        "https://www.w3.org/Style/XSL/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"xsl", "xslt"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * XSL Formatting Objects.
     * 
     * <p>File extensions: {@code fob}, {@code fo}</p>
     * 
     * @see <a href="https://www.w3.org/TR/xsl11/">https://www.w3.org/TR/xsl11/</a>
     */
    XSLFO(
        "XSL-FO",
        "XSL Formatting Objects",
        "https://www.w3.org/TR/xsl11/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|<!--"),
        new String[] {"fob", "fo"},
        new BlockDelimiter[] {new BlockDelimiter("<!--", "-->")}
    ) {
    },
    /**
     * Xtend programming language.
     * 
     * <p>File extensions: {@code xtend}</p>
     * 
     * @see <a href="https://en.wikipedia.org/wiki/Xtend">https://en.wikipedia.org/wiki/Xtend</a>
     */
    Xtend(
        "Xtend",
        "Xtend programming language",
        "https://en.wikipedia.org/wiki/Xtend",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'"), new BlockDelimiter("'''", "'''")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\"|'|'''|/\\*"),
        new String[] {"xtend"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * YAML Ain't Markup Language(TM).
     * 
     * <p>File extensions: {@code yaml}, {@code yml}</p>
     * 
     * @see <a href="https://yaml.org/">https://yaml.org/</a>
     */
    Yaml(
        "YAML",
        "YAML Ain't Markup Language(TM)",
        "https://yaml.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"yaml", "yml"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    },
    /**
     * ZenCode programming language.
     * 
     * <p>File extensions: {@code zs}</p>
     * 
     * @see <a href="https://zencode.blamejared.com/language/">https://zencode.blamejared.com/language/</a>
     */
    ZenCode(
        "ZenCode",
        "ZenCode programming language",
        "https://zencode.blamejared.com/language/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {new BlockDelimiter("@\"", "\""), new BlockDelimiter("@'", "'")},
        new BlockDelimiter[] {},
        compile("\"|'|/\\*"),
        new String[] {"zs"},
        new BlockDelimiter[] {new BlockDelimiter("/*", "*/")}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//") || predicate.test("#");
        }

        @Override
        public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
            for (int i = 0; i < this.verbatimQuotes.length; i++) {
                if (predicate.test(this.verbatimQuotes[i])) {
                    return true;
                }
            }
            return false;
        }

    },
    /**
     * Zig programming language.
     * 
     * <p>File extensions: {@code zig}</p>
     * 
     * @see <a href="https://ziglang.org/">https://ziglang.org/</a>
     */
    Zig(
        "Zig",
        "Zig programming language",
        "https://ziglang.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\"")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("\""),
        new String[] {"zig"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("//");
        }

    },
    /**
     * Z shell.
     * 
     * <p>File extensions: {@code zsh}</p>
     * 
     * @see <a href="https://www.zsh.org/">https://www.zsh.org/</a>
     */
    Zsh(
        "Zsh",
        "Z shell",
        "https://www.zsh.org/",
        new BlockDelimiter[] {},
        new BlockDelimiter[] {new BlockDelimiter("\"", "\""), new BlockDelimiter("'", "'")},
        new BlockDelimiter[] {},
        new BlockDelimiter[] {},
        compile("[\"']"),
        new String[] {"zsh"},
        new BlockDelimiter[] {}
    ) {
        @Override
        public boolean isLineComment(final Predicate<CharSequence> predicate) {
            return predicate.test("#");
        }

    };

    private static final Map<String, Language> DISPLAY_NAMES = new HashMap<>();
    private static final Map<String, Language> EXTENSIONS = new HashMap<>();
    private static final String ENV_SHEBANG = "#!/usr/bin/env";
    private static final Pattern WHITESPACE_REGEX = compile("\\s+");

    final BlockDelimiter[] nestedComments;
    final BlockDelimiter[] verbatimQuotes;
    
    final Pattern importantSyntax;

    private final String displayName;
    
    private final String description;
    
    private final String website;
    private final BlockDelimiter[] quotes;
    private final BlockDelimiter[] docQuotes;
    private final String[] extensions;
    private final BlockDelimiter[] allMultiLineComments;

    static {
        // Static maps must be used to avoid generating methods that exceed the JVM method byte code limit.
        for (final Language language : values()) {
            DISPLAY_NAMES.put(language.getDisplayName().toLowerCase(Locale.ROOT), language);
        }
        resetExtensions();
    }

    Language(final String displayName, final String description, final String website,
             final BlockDelimiter[] nestedComments, final BlockDelimiter[] quotes,
             final BlockDelimiter[] verbartimQuotes, final BlockDelimiter[] docQuotes,
             final Pattern importantSyntax,
             final String[] extensions, final BlockDelimiter[] allMultiLineComments) {
        this.displayName = displayName;
        this.description = description;
        this.website = website;
        this.nestedComments = nestedComments;
        this.quotes = quotes;
        this.verbatimQuotes = verbartimQuotes;
        this.docQuotes = docQuotes;
        this.importantSyntax = importantSyntax;
        this.extensions = extensions;
        this.allMultiLineComments = allMultiLineComments;
    }

    /**
     * Obtains the display name for the language. This is user interface displayable name for the language and may
     * differ from the language enum name if it has spaces or contains characters not allowed in an enum (e.g. C++,
     * C#, C Shell).
     *
     * @return Display name for the language
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Obtains the description of the language.
     *
     * @return Description of the language.
     */
    
    public String getDescription() {
        return this.description;
    }

    /**
     * Obtains the URL of a website that provides detailed information about the language. Typically, this is the
     * official site for the language. If there is no official site, an alternate source of information may be
     * provided (e.g. Wikipedia).
     *
     * @return URL of a website providing detailed information about the language.
     */
    
    public String getWebsite() {
        return this.website;
    }

    /**
     * Adds the specified file extension to specified language's list of extensions. If an extension already
     * maps to a language, it is replaced.
     *
     * @param extension File extension to add (without the leading period). Extensions are case-insensitive.
     * @param language Language to map to the specified extension
     */
    public static void addExtension(final String extension, final Language language) {
        EXTENSIONS.put(extension.toLowerCase(Locale.ROOT), language);
    }

    /**
     * Removes the specified file extension. If the extension is not present, this method does nothing.
     *
     * @param extension File extension to remove (without the leading period). Extensions are case-insensitive.
     */
    public static void removeExtension(final String extension) {
        EXTENSIONS.remove(extension);
    }

    /**
     * Obtains a read-only map of file extensions to languages.
     *
     * @return Read-only map of file extensions to languages.
     */
    public static Map<String, Language> getExtensions() {
        return Collections.unmodifiableMap(EXTENSIONS);
    }

    /**
     * Restores the file extension to language mapping to its default.
     */
    public static void resetExtensions() {
        EXTENSIONS.clear();
        for (final Language language : values()) {
            for (int i = 0; i < language.extensions.length; i++) {
                EXTENSIONS.put(language.extensions[i], language);
            }
        }
    }

    /**
     * Indicates whether the specified predicate is true for line comments.
     *
     * @param predicate Tests for line comments.
     * @return {@code true} if the predicate is true for line comments.
     */
    public boolean isLineComment(final Predicate<CharSequence> predicate) {
        return false;
    }

    /**
     * Indicates whether multiline comments can be nested.
     *
     * @return {@code true} if the language allows nesting of comments.
     */
    public boolean isNestable() {
        return false;
    }

    /**
     * Indicates whether the specified predicate is true for nested comments.
     *
     * @param predicate Tests for nested comments.
     * @return {@code true} if the predicate is true for nested comments.
     */
    public boolean isNestedComment(final Predicate<BlockDelimiter> predicate) {
        return false;
    }

    /**
     * Indicates whether the specified predicate is true for normal quotes.
     *
     * @param predicate Tests for normal quotes.
     * @return {@code true} if the predicate is true for normal quotes.
     */
    public boolean isQuote(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.quotes.length; i++) {
            if (predicate.test(this.quotes[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provides the normal quote for which the specified predicate is true.
     *
     * @param predicate Tests for normal quotes.
     * @return Normal quote for which the specified predicate is true.
     */
    
    public BlockDelimiter findQuote(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.quotes.length; i++) {
            final BlockDelimiter delim = this.quotes[i];
            if (predicate.test(delim)) {
                return delim;
            }
        }
        return null;
    }

    /**
     * Indicates whether the specified predicate is true for verbatim quotes.
     *
     * @param predicate Tests for verbatim quotes.
     * @return {@code true} if the predicate is true for verbatim quotes.
     */
    public boolean isVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
        return false;
    }

    /**
     * Provides the verbatim quote for which the specified predicate is true.
     *
     * @param predicate Tests for verbatim quotes.
     * @return Verbatim quote for which the specified predicate is true.
     */
    
    public BlockDelimiter findVerbatimQuote(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.verbatimQuotes.length; i++) {
            final BlockDelimiter delim = this.verbatimQuotes[i];
            if (predicate.test(delim)) {
                return delim;
            }
        }
        return null;
    }

    /**
     * Indicates whether the specified predicate is true for documentation quotes.
     *
     * @param predicate Tests for documentation quotes.
     * @return {@code true} if the predicate is true for documentation quotes.
     */
    public boolean isDocQuote(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.docQuotes.length; i++) {
            if (predicate.test(this.docQuotes[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provides the documentation quote for which the specified predicate is true.
     *
     * @param predicate Tests for documentation quotes.
     * @return Documentation quote for which the specified predicate is true.
     */
    
    public BlockDelimiter findDocQuote(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.docQuotes.length; i++) {
            final BlockDelimiter delim = this.docQuotes[i];
            if (predicate.test(delim)) {
                return delim;
            }
        }
        return null;
    }

    /**
     * Indicates whether the column position of a character sequence must be preserved because it
     * is significant to the language. For example, in legacy FORTRAN a "C" in the first column
     * indicates a line comment.
     *
     * @return {@code true} if the column position of a character is significant.
     */
    public boolean isColumnSignificant() {
        return false;
    }

    /**
     * Obtains a regular expression to match against syntax that is considered important for counting.
     *
     * @return Regular expression to match against important syntax.
     */
    
    public Pattern getImportantSyntax() {
        return this.importantSyntax;
    }

    /**
     * Obtains the syntax for embedding other languages within this language.
     *
     * @return Syntax for embedding other languages.
     */
    public Embedding.Syntax getEmbedSyntax() {
        return null;
    }

    /**
     * Indicates whether the specified predicate is true for any multiline comments.
     *
     * @param predicate Tests for multiline comments.
     * @return {@code true} if the predicate is true for multiline comments.
     */
    public boolean isAnyMultiLineComment(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.allMultiLineComments.length; i++) {
            if (predicate.test(this.allMultiLineComments[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provides the multiline comment delimiter for which the specified predicate is true.
     *
     * @param predicate Tests for the multiline comment delimiter.
     * @return Multiline comment delimiter for which the specified predicate is true.
     */
    
    public BlockDelimiter findAnyMultiLineComment(final Predicate<BlockDelimiter> predicate) {
        for (int i = 0; i < this.allMultiLineComments.length; i++) {
            final BlockDelimiter delim = this.allMultiLineComments[i];
            if (predicate.test(delim)) {
                return delim;
            }
        }
        return null;
    }

    /**
      * Attempts to obtain the language of a file by attempting to match the following:
      * <ol>
      *     <li>The name of the file against any filenames for a language (e.g. Makefile)</li>
      *     <li>The extension of the file against any filename extensions for a language (e.g. cpp)</li>
      *     <li>The shebang in the first line of the file against any shebang interpreters or {@code env}
      *         programs for a language</li>
      * </ol>
      *
      * @param file File whose language is to be determined
      * @return Language corresponding to the specified file. If the file cannot be found or read, or the language
      *     cannot be determined, an empty {@link Optional} is returned.
      */
    public static Optional<Language> fromFile(final Path file) {
        if (Files.isDirectory(file)) {
            throw new IllegalArgumentException("Path must be a file");
        }

        final Path filenamePath = file.getFileName();
        if (filenamePath == null) {
            throw new IllegalArgumentException("Path is empty");
        }
        final String filename = filenamePath.toString().toLowerCase(Locale.ROOT);

        switch (filename) {
            case "build", "workspace": return Optional.of(Bazel);
            case "cmakelists.txt": return Optional.of(CMake);
            case "dockerfile": return Optional.of(Dockerfile);
            case "build.gradle.kts", "settings.gradle.kts": return Optional.of(GradleKotlin);
            case "makefile": return Optional.of(Makefile);
            case "meson.build", "meson_options.txt": return Optional.of(Meson);
            case "nuget.config", "packages.config", "nugetdefaults.config": return Optional.of(NuGetConfig);
            case "pkgbuild": return Optional.of(PacmanMakepkg);
            case "pom.xml": return Optional.of(POM);
            case "rakefile": return Optional.of(Rakefile);
            case "sconstruct", "sconscript": return Optional.of(Scons);
            default: break;
        }

        final int extIdx = filename.lastIndexOf('.');
        return (extIdx == -1 || filename.length() < 2)
                ? fromShebang(file)
                : fromFileExtension(filename.substring(extIdx + 1)).or(() -> fromShebang(file));
    }

    /**
     * Attempts to obtain the language of a file based on its MIME type.
     *
     * <p>
     * The supported MIME types and their corresponding language are:
     * </p>
     * <ul>
     *   <li>{@code text/x-asm . . . . . . . . . . . . } <a href="#Assembly">Assembly</a></li>
     *   <li>{@code application/x-csh. . . . . . . . . } <a href="#CShell">CShell</a></li>
     *   <li>{@code text/css . . . . . . . . . . . . . } <a href="#Css">Css</a></li>
     *   <li>{@code text/html. . . . . . . . . . . . . } <a href="#Html">Html</a></li>
     *   <li>{@code text/x-java-source . . . . . . . . } <a href="#Java">Java</a></li>
     *   <li>{@code application/javascript . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code application/ecmascript . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code application/x-ecmascript . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code application/x-javascript . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript. . . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/ecmascript. . . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.0 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.1 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.2 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.3 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.4 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/javascript1.5 . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/jscript . . . . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/livescript. . . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/x-ecmascript. . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code text/x-javascript. . . . . . . . . } <a href="#JavaScript">JavaScript</a></li>
     *   <li>{@code application/json . . . . . . . . . } <a href="#Json">Json</a></li>
     *   <li>{@code application/manifest+json. . . . . } <a href="#Json">Json</a></li>
     *   <li>{@code text/markdown. . . . . . . . . . . } <a href="#Markdown">Markdown</a></li>
     *   <li>{@code text/x-markdown. . . . . . . . . . } <a href="#Markdown">Markdown</a></li>
     *   <li>{@code application/x-perl . . . . . . . . } <a href="#Perl">Perl</a></li>
     *   <li>{@code text/x-python. . . . . . . . . . . } <a href="#Python">Python</a></li>
     *   <li>{@code image/svg+xml. . . . . . . . . . . } <a href="#Svg">Svg</a></li>
     *   <li>{@code text/plain . . . . . . . . . . . . } <a href="#Text">Text</a></li>
     *   <li>{@code application/xslt+xml . . . . . . . } <a href="#XSL">XSL</a></li>
     *   <li>{@code application/yaml . . . . . . . . . } <a href="#Yaml">Yaml</a></li>
     * </ul>
     *
     * @param mimeType File MIME type
     * @return Language corresponding to the specified MIME type. If the language cannot be determined, an empty
     *      {@link Optional} is returned.
     */
    public static Optional<Language> fromMime(final String mimeType) {
        return switch (mimeType) {
            case "text/x-asm" -> Optional.of(Assembly);
            case "application/x-csh" -> Optional.of(CShell);
            case "text/css" -> Optional.of(Css);
            case "text/html" -> Optional.of(Html);
            case "text/x-java-source" -> Optional.of(Java);
            case "application/javascript", "application/ecmascript", "application/x-ecmascript", "application/x-javascript", "text/javascript", "text/ecmascript", "text/javascript1.0", "text/javascript1.1", "text/javascript1.2", "text/javascript1.3", "text/javascript1.4", "text/javascript1.5", "text/jscript", "text/livescript", "text/x-ecmascript", "text/x-javascript" -> Optional.of(JavaScript);
            case "application/json", "application/manifest+json" -> Optional.of(Json);
            case "text/markdown", "text/x-markdown" -> Optional.of(Markdown);
            case "application/x-perl" -> Optional.of(Perl);
            case "text/x-python" -> Optional.of(Python);
            case "image/svg+xml" -> Optional.of(Svg);
            case "text/plain" -> Optional.of(Text);
            case "application/xslt+xml" -> Optional.of(XSL);
            case "application/yaml" -> Optional.of(Yaml);
            default -> Optional.empty();
        };
    }

    /**
     * Attempts to obtain the language of a file based on its file extension.
     *
     * @param extension File extension to search (without the leading ".")
     * @return Language corresponding to the specified file extension. If the language cannot be determined, an
     *      empty {@link Optional} is returned. The matching is case-insensitive.
     */
    public static Optional<Language> fromFileExtension(final String extension) {
        return Optional.ofNullable(EXTENSIONS.get(extension.toLowerCase(Locale.ROOT)));
    }

    /**
    * Attempts to obtain the language corresponding to the specified language identifier.
    *
    * @param id Language identifier to find
    * @return Language corresponding to the specified identifier. Comparisons are case-insensitive. If the language
    *       cannot be determined, an empty {@link Optional} is returned.
    */
    public static Optional<Language> fromId(final String id) {
        final String normalizedId = id.toLowerCase(Locale.ROOT);
        for (final Language language : values()) {
            if (language.toString().toLowerCase(Locale.ROOT).equals(normalizedId)) {
                return Optional.of(language);
            }
        }
        return Optional.empty();
    }

    /**
     * Attempts to obtain the language corresponding to the specified language display name.
     *
     * @param langDisplayName Display name of the language to find
     * @return Language corresponding to the specified display name. Comparisons are case-insensitive.
      *     If the language cannot be determined, an empty {@link Optional} is returned.
     */
    public static Optional<Language> fromDisplayName(final String langDisplayName) {
        return Optional.ofNullable(DISPLAY_NAMES.get(langDisplayName.toLowerCase(Locale.ROOT)));
    }

    /**
     * Attempts to obtain the language of the specified file based on a shebang ("#!") on its first line.
     * The shebang is first compared against the shebang interpreters listed for each language. If an
     * interpreter is not matched, the {@code env} program argument is checked.
     *
     * <p>
     * The supported interpreters and their corresponding language are:
     * </p>
     * <ul>
     *   <li>{@code #!/bin/awk -f. . . . . . } <a href="#AWK">AWK</a></li>
     *   <li>{@code #!/bin/bash. . . . . . . } <a href="#Bash">Bash</a></li>
     *   <li>{@code #!/usr/bin/crystal . . . } <a href="#Crystal">Crystal</a></li>
     *   <li>{@code #!/bin/csh . . . . . . . } <a href="#CShell">CShell</a></li>
     *   <li>{@code #!/bin/expect. . . . . . } <a href="#Expect">Expect</a></li>
     *   <li>{@code #!/bin/fish. . . . . . . } <a href="#Fish">Fish</a></li>
     *   <li>{@code #!/bin/ksh . . . . . . . } <a href="#Ksh">Ksh</a></li>
     *   <li>{@code #!/usr/bin/perl. . . . . } <a href="#Perl">Perl</a></li>
     *   <li>{@code #!/usr/bin/raku. . . . . } <a href="#Raku">Raku</a></li>
     *   <li>{@code #!/usr/bin/perl6 . . . . } <a href="#Raku">Raku</a></li>
     *   <li>{@code #!/bin/sed -f. . . . . . } <a href="#Sed">Sed</a></li>
     *   <li>{@code #!/bin/sh. . . . . . . . } <a href="#Sh">Sh</a></li>
     *   <li>{@code #!/bin/zsh . . . . . . . } <a href="#Zsh">Zsh</a></li>
     * </ul>
     *
     * <p>
     * The supported environment programs are:
     * </p>
     * <ul>
     *   <li>{@code bash . . . . . . . . . . } <a href="#Bash">Bash</a></li>
     *   <li>{@code crystal. . . . . . . . . } <a href="#Crystal">Crystal</a></li>
     *   <li>{@code csh. . . . . . . . . . . } <a href="#CShell">CShell</a></li>
     *   <li>{@code cython . . . . . . . . . } <a href="#Cython">Cython</a></li>
     *   <li>{@code elvish . . . . . . . . . } <a href="#Elvish">Elvish</a></li>
     *   <li>{@code fish . . . . . . . . . . } <a href="#Fish">Fish</a></li>
     *   <li>{@code groovy . . . . . . . . . } <a href="#Groovy">Groovy</a></li>
     *   <li>{@code ksh. . . . . . . . . . . } <a href="#Ksh">Ksh</a></li>
     *   <li>{@code python . . . . . . . . . } <a href="#Python">Python</a></li>
     *   <li>{@code python2. . . . . . . . . } <a href="#Python">Python</a></li>
     *   <li>{@code python3. . . . . . . . . } <a href="#Python">Python</a></li>
     *   <li>{@code racket . . . . . . . . . } <a href="#Racket">Racket</a></li>
     *   <li>{@code raku . . . . . . . . . . } <a href="#Raku">Raku</a></li>
     *   <li>{@code perl6. . . . . . . . . . } <a href="#Raku">Raku</a></li>
     *   <li>{@code ruby . . . . . . . . . . } <a href="#Ruby">Ruby</a></li>
     *   <li>{@code sh . . . . . . . . . . . } <a href="#Sh">Sh</a></li>
     * </ul>
     *
     * @param file File whose shebang is to be matched
     * @return Language corresponding to the specified file's shebang, if found.
     */
    public static Optional<Language> fromShebang(final Path file) {
        if (Files.isDirectory(file)) {
            throw new IllegalArgumentException("Path must be a file");
        }

        final String firstLine;

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            firstLine = reader.readLine();
        } catch (final IOException ex) {
            return Optional.empty();
        }

        if (firstLine == null) {
            return Optional.empty();
        }

        final String[] words = WHITESPACE_REGEX.split(firstLine);
        if (words.length == 0) {
            return Optional.empty();
        }

        // First try looking for a shebang interpreter
        switch (words[0]) {
            case "#!/bin/awk -f": return Optional.of(AWK);
            case "#!/bin/bash": return Optional.of(Bash);
            case "#!/usr/bin/crystal": return Optional.of(Crystal);
            case "#!/bin/csh": return Optional.of(CShell);
            case "#!/bin/expect": return Optional.of(Expect);
            case "#!/bin/fish": return Optional.of(Fish);
            case "#!/bin/ksh": return Optional.of(Ksh);
            case "#!/usr/bin/perl": return Optional.of(Perl);
            case "#!/usr/bin/raku", "#!/usr/bin/perl6": return Optional.of(Raku);
            case "#!/bin/sed -f": return Optional.of(Sed);
            case "#!/bin/sh": return Optional.of(Sh);
            case "#!/bin/zsh": return Optional.of(Zsh);
            default: break;
        }

        // Next try looking for a shebang env program
        if (words.length < 2 || !ENV_SHEBANG.equals(words[0])) {
            return Optional.empty();
        }

        return switch (words[1]) {
            case "bash" -> Optional.of(Bash);
            case "crystal" -> Optional.of(Crystal);
            case "csh" -> Optional.of(CShell);
            case "cython" -> Optional.of(Cython);
            case "elvish" -> Optional.of(Elvish);
            case "fish" -> Optional.of(Fish);
            case "groovy" -> Optional.of(Groovy);
            case "ksh" -> Optional.of(Ksh);
            case "python", "python2", "python3" -> Optional.of(Python);
            case "racket" -> Optional.of(Racket);
            case "raku", "perl6" -> Optional.of(Raku);
            case "ruby" -> Optional.of(Ruby);
            case "sh" -> Optional.of(Sh);
            default -> Optional.empty();
        };
    }
}
