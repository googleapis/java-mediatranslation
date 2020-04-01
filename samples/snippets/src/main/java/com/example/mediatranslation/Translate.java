/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mediatranslation;

public class Translate {
  public static void main(String[] args) {
    try {
      argsHelper(args);
    } catch (Exception e) {
      System.out.println("Exception while running:\n" + e.getMessage() + "\n");
      e.printStackTrace(System.out);
    }
  }

  public static void argsHelper(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("Usage:");
      System.out.printf(
              "\tjava %s \"<command>\" \"<path-to-file>\"\n"
                      + "Commands:\n"
                      + "\ttranslate_from_file | translate_from_mic\n"
                      + "Path:\n\t Local media file to translate (path/to/audio/file.raw)\n"
                      + "Examples: translate_from_file directory/audio.raw",
              Translate.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    if (command.equals("translate_from_file")) {
      TranslateFromFile.translateFromFile(path);
    }
    if (command.equals("translate_from_mic")) {
      TranslateFromMic.translateFromMic();
    }
  }

}
