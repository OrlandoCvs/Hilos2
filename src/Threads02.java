import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Threads02 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String name = file.toAbsolutePath().toString();

        if( name.endsWith(".txt") ) {
            Thread contador = new Thread( new ContadorDeLineas(name) );
            contador.start();
        }
        return super.visitFile(file, attrs);
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No se puede procesar:%30s%n", file.toString()) ;
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {
        long tiempo1;
        long tiempo2 = 0;
        long l1;
        long l2 = 0;

        if (args.length == 0){
            System.exit(0);
        }
        Path startingDir = Paths.get(args[0]);
      Threads02 contadorLineas = new Threads02();
        Files.walkFileTree(startingDir, contadorLineas);
    }
}