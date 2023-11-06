package org.aren.particlemaster.compiler;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import org.aren.particlemaster.compiler.exception.TypeErrorException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;
import java.util.regex.Pattern;

public class Tokenizer {

    public static JSONArray tokenize(List<Character> lexers) throws TypeErrorException {
        int current = 0;
        JSONArray jsonArray = new JSONArray();

        while(current < lexers.size()) {
            Character lexer = lexers.get(current);
            System.out.println("현재 진행 중 : " + current);

            if (lexer == ' ') {
                current++;
                continue;
            }
            if (lexer == ',') {
                current++;
                continue;
            }
            if (lexer == ';') {
                current++;
                continue;
            }

            if (lexer == '(') {
                JSONObject object = new JSONObject();
                object.put("type", TokenType.OpenParantheses.toString());
                object.put("value", lexer.toString());

                jsonArray.add(object);
                current++;
                continue;
            }

            if (lexer == ')') {
                JSONObject object = new JSONObject();
                object.put("type", TokenType.CloseParantheses.toString());
                object.put("value", lexer.toString());

                jsonArray.add(object);
                current++;
                continue;
            }

            if (lexer == '{') {
                JSONObject object = new JSONObject();
                object.put("type", TokenType.OpenBraces.toString());
                object.put("value", lexer.toString());

                jsonArray.add(object);
                current++;
                continue;
            }

            if (lexer == '}') {
                JSONObject object = new JSONObject();
                object.put("type", TokenType.CloseBraces.toString());
                object.put("value", lexer.toString());

                jsonArray.add(object);
                current++;
                continue;
            }



            if (Pattern.matches("[0-9]", lexer.toString())) {
                StringBuilder stringBuilder = new StringBuilder(lexer.toString());
                JSONObject object = new JSONObject();

                while (Pattern.matches("[0-9]", lexers.get(++current).toString())
                    || lexer == '.') {
                    lexer = lexers.get(current);
                    stringBuilder.append(lexer);
                }

                object.put("type", TokenType.NumberLiteral.toString());
                object.put("value", stringBuilder.toString());

                jsonArray.add(object);
                continue;
            }

            if (lexer == '\"') {
                StringBuilder builder = new StringBuilder();
                JSONObject object = new JSONObject();

                while (lexers.get(++current) != '\"') {
                    lexer = lexers.get(current);
                    builder.append(lexer);
                }

//                "" 를 지우고 내부의 데이터만을 저장
                current++;

                object.put("type", TokenType.StringLiteral.toString());
                object.put("value", builder.toString());
                jsonArray.add(object);
                continue;
            }

            if (Pattern.matches("[a-zA-Z]", lexer.toString())) {
                StringBuilder builder = new StringBuilder(lexer.toString());
                JSONObject object = new JSONObject();

                while (Pattern.matches("[a-zA-Z]", lexers.get(++current).toString())) {
                    lexer = lexers.get(current);
                    builder.append(lexer);
                }

                object.put("type", TokenType.LETTER.toString());
                object.put("value", builder.toString());
                jsonArray.add(object);
                continue;
            }

            if (lexer.toString().matches("[=\\-+/*%!]")) {
                StringBuilder builder = new StringBuilder(lexer.toString());
                JSONObject object = new JSONObject();

                while (Pattern.matches("[=\\-+/*%!]", lexers.get(++current).toString())) {
                    lexer = lexers.get(current);
                    builder.append(lexer);
                }

                object.put("type", TokenType.Operator.toString());
                object.put("value", builder.toString());
                jsonArray.add(object);
                continue;
            }

            throw new TypeErrorException("I don't know this character : " + lexer);
        }

        return jsonArray;
    }

}
