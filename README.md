# ASCII Art Converter

## Introduction

Welcome to the ASCII Art Converter! This is a simple console-executable application that allows you to transform images into ASCII art. The application provides flexibility by allowing you to apply various filters and specify the output format.

## Application Basics

The application follows a straightforward process:

1. **Load an Image:** Load an image from a specified file path.
2. **Translate into ASCII Art:** Transform the loaded image into ASCII art.
3. **Apply Filters:** Apply optional filters such as rotation, scaling and flipping.
4. **Output the Image:** Choose the output destination for the ASCII art (console, file or both).

## Usage

When running the application within the sbt shell, you can use the `run` command with various arguments to customize the conversion process:

### Example Commands

1. run --image "accets/butterfly.jpg" --output-console
2. run --image "accets/grape_fruit.png" --rotate +90 --scale 0.25 --output-console
3. run --image "accets/butterfly.jpg" --rotate -180 --output-file "accets/output.txt" --output-console

