import { PageLayout, SharedLayout } from "./quartz/cfg"
import * as Component from "./quartz/components"
import { Options } from "./quartz/components/Explorer"

const explorerOptions: Partial<Options> = {
  mapFn: (node) => {
    const shortNameTag = node.data?.tags?.find((tag) => /^shortname[/:=].+/i.test(tag))
    const shortName = shortNameTag?.replace(/^shortname[/:=]\s*/i, "")?.trim()

    if (shortName) {
      node.displayName = shortName
    }

    // node.displayName = node.displayName.toUpperCase()
    // if (node.isFolder) {
    //   node.displayName = "📁 " + node.displayName
    // }
    // else {
    //   node.displayName = "📄 " + node.displayName
    // }
    return node
  },
  sortFn: (a, b) => {
    return a.displayName.localeCompare(b.displayName)
  },
}

// components shared across all pages
export const sharedPageComponents: SharedLayout = {
  head: Component.Head(),
  header: [],
  afterBody: [
    Component.Comments({
      provider: "giscus",
      options: {
        // from data-repo
        repo: "manu-palmero/apuntes",
        // from data-repo-id
        repoId: "R_kgDOP3fW3w",
        // from data-category
        category: "General",
        // from data-category-id
        categoryId: "DIC_kwDOP3fW384C5qm0",
        // from data-lang
        lang: "es",
      },
    }),
  ],
  footer: Component.Footer({
    links: {
      GitHub: "https://github.com/manu-palmero/apuntes",
    },
  }),
}

// components for pages that display a single page (e.g. a single note)
export const defaultContentPageLayout: PageLayout = {
  beforeBody: [
    Component.ConditionalRender({
      component: Component.Breadcrumbs(),
      condition: (page) => page.fileData.slug !== "index",
    }),
    Component.ArticleTitle(),
    Component.ContentMeta(),
    Component.TagList(),
  ],
  left: [
    Component.PageTitle(),
    Component.MobileOnly(Component.Spacer()),
    Component.Flex({
      components: [
        {
          Component: Component.Search(),
          grow: true,
        },
        { Component: Component.Darkmode() },
        { Component: Component.ReaderMode() },
      ],
    }),
    Component.Explorer(explorerOptions),
  ],
  right: [
    // Component.Graph(),
    Component.DesktopOnly(Component.TableOfContents()),
    Component.Backlinks(),
  ],
}

// components for pages that display lists of pages  (e.g. tags or folders)
export const defaultListPageLayout: PageLayout = {
  beforeBody: [Component.Breadcrumbs(), Component.ArticleTitle(), Component.ContentMeta()],
  left: [
    Component.PageTitle(),
    Component.MobileOnly(Component.Spacer()),
    Component.Flex({
      components: [
        {
          Component: Component.Search(),
          grow: true,
        },
        { Component: Component.Darkmode() },
      ],
    }),
    Component.Explorer(explorerOptions),
  ],
  right: [],
}
