import { Translation } from "./definition"

export default {
  propertyDefaults: {
    title: "Senza titolo",
    description: "Nessuna descrizione",
  },
  components: {
    callout: {
      note: "Nota",
<<<<<<< HEAD
      abstract: "Astratto",
=======
      abstract: "Abstract",
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
      info: "Info",
      todo: "Da fare",
      tip: "Consiglio",
      success: "Completato",
      question: "Domanda",
      warning: "Attenzione",
      failure: "Errore",
      danger: "Pericolo",
<<<<<<< HEAD
      bug: "Bug",
=======
      bug: "Problema",
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
      example: "Esempio",
      quote: "Citazione",
    },
    backlinks: {
      title: "Link entranti",
      noBacklinksFound: "Nessun link entrante",
    },
    themeToggle: {
      lightMode: "Tema chiaro",
      darkMode: "Tema scuro",
    },
    readerMode: {
      title: "Modalità lettura",
    },
    explorer: {
      title: "Esplora",
    },
    footer: {
      createdWith: "Creato con",
    },
    graph: {
      title: "Vista grafico",
    },
    recentNotes: {
      title: "Note recenti",
<<<<<<< HEAD
      seeRemainingMore: ({ remaining }) => `Vedi ${remaining} altro →`,
    },
    transcludes: {
      transcludeOf: ({ targetSlug }) => `Transclusione di ${targetSlug}`,
=======
      seeRemainingMore: ({ remaining }) =>
        remaining === 1 ? "Vedi 1 altra →" : `Vedi altre ${remaining} →`,
    },
    transcludes: {
      transcludeOf: ({ targetSlug }) => `Inclusione di ${targetSlug}`,
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
      linkToOriginal: "Link all'originale",
    },
    search: {
      title: "Cerca",
      searchBarPlaceholder: "Cerca qualcosa",
    },
    tableOfContents: {
<<<<<<< HEAD
      title: "Tabella dei contenuti",
    },
    contentMeta: {
      readingTime: ({ minutes }) => `${minutes} minuti`,
=======
      title: "Indice",
    },
    contentMeta: {
      readingTime: ({ minutes }) => (minutes === 1 ? "1 minuto" : `${minutes} minuti`),
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
  },
  pages: {
    rss: {
      recentNotes: "Note recenti",
<<<<<<< HEAD
      lastFewNotes: ({ count }) => `Ultime ${count} note`,
=======
      lastFewNotes: ({ count }) => (count === 1 ? "Ultima nota" : `Ultime ${count} note`),
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
    error: {
      title: "Non trovato",
      notFound: "Questa pagina è privata o non esiste.",
      home: "Ritorna alla home page",
    },
    folderContent: {
      folder: "Cartella",
      itemsUnderFolder: ({ count }) =>
        count === 1 ? "1 oggetto in questa cartella." : `${count} oggetti in questa cartella.`,
    },
    tagContent: {
      tag: "Etichetta",
      tagIndex: "Indice etichette",
      itemsUnderTag: ({ count }) =>
        count === 1 ? "1 oggetto con questa etichetta." : `${count} oggetti con questa etichetta.`,
<<<<<<< HEAD
      showingFirst: ({ count }) => `Prime ${count} etichette.`,
      totalTags: ({ count }) => `Trovate ${count} etichette totali.`,
=======
      showingFirst: ({ count }) => (count === 1 ? "Prima etichetta." : `Prime ${count} etichette.`),
      totalTags: ({ count }) =>
        count === 1 ? "Trovata 1 etichetta in totale." : `Trovate ${count} etichette totali.`,
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
  },
} as const satisfies Translation
