package org.sirix.access;

import java.io.StringWriter;
import java.io.Writer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sirix.JsonTestHelper;
import org.sirix.JsonTestHelper.PATHS;
import org.sirix.exception.SirixException;
import org.sirix.service.json.serialize.JsonSerializer;

public final class JsonDocumentTest {
  @Before
  public void setUp() throws SirixException {
    JsonTestHelper.deleteEverything();
  }

  @After
  public void tearDown() throws SirixException {
    JsonTestHelper.closeEverything();
  }

  @Test
  public void testJsonDocument() {
    JsonTestHelper.createTestDocument();

    final var database = JsonTestHelper.getDatabase(PATHS.PATH1.getFile());
    try (final var manager = database.getResourceManager(JsonTestHelper.RESOURCE)) {
      final Writer writer = new StringWriter();
      final var serializer = new JsonSerializer.JsonSerializerBuilder(manager, writer).build();
      // serializer.call();
    }
  }
}