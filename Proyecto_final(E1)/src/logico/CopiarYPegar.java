    package logico;

    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.nio.file.StandardCopyOption;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    /**
     *
     * @author SoftMolina
     */
    public class CopiarYPegar {

        static final Logger LOGGER = Logger.getAnonymousLogger();

        public CopiarYPegar(String origenArchivo, String destinoArchivo) {
            try {
                Path origenPath = Paths.get(origenArchivo);
                Path destinoPath = Paths.get(destinoArchivo);
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (FileNotFoundException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage());
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage());
            }
        }

       public static void main(String args[]) {
        if(args.length == 2)
            new CopiarYPegar(args[0], args[1]);
        else
            System.out.println("Debe ingresar dos parametros");
       }

    }