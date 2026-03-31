import { Translation } from "./definition"

export default {
  propertyDefaults: {
    title: "Không có tiêu đề",
<<<<<<< HEAD
    description: "Không có mô tả được cung cấp",
  },
  components: {
    callout: {
      note: "Ghi Chú",
      abstract: "Tóm Tắt",
      info: "Thông tin",
      todo: "Cần Làm",
      tip: "Gợi Ý",
      success: "Thành Công",
      question: "Nghi Vấn",
      warning: "Cảnh Báo",
      failure: "Thất Bại",
      danger: "Nguy Hiểm",
      bug: "Lỗi",
      example: "Ví Dụ",
      quote: "Trích Dẫn",
    },
    backlinks: {
      title: "Liên Kết Ngược",
      noBacklinksFound: "Không có liên kết ngược được tìm thấy",
    },
    themeToggle: {
      lightMode: "Sáng",
      darkMode: "Tối",
=======
    description: "Không có mô tả",
  },
  components: {
    callout: {
      note: "Ghi chú",
      abstract: "Tổng quan",
      info: "Thông tin",
      todo: "Cần phải làm",
      tip: "Gợi ý",
      success: "Thành công",
      question: "Câu hỏi",
      warning: "Cảnh báo",
      failure: "Thất bại",
      danger: "Nguy hiểm",
      bug: "Lỗi",
      example: "Ví dụ",
      quote: "Trích dẫn",
    },
    backlinks: {
      title: "Liên kết ngược",
      noBacklinksFound: "Không có liên kết ngược nào",
    },
    themeToggle: {
      lightMode: "Chế độ sáng",
      darkMode: "Chế độ tối",
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
    readerMode: {
      title: "Chế độ đọc",
    },
    explorer: {
<<<<<<< HEAD
      title: "Trong bài này",
    },
    footer: {
      createdWith: "Được tạo bởi",
    },
    graph: {
      title: "Biểu Đồ",
    },
    recentNotes: {
      title: "Bài viết gần đây",
      seeRemainingMore: ({ remaining }) => `Xem ${remaining} thêm →`,
    },
    transcludes: {
      transcludeOf: ({ targetSlug }) => `Bao gồm ${targetSlug}`,
      linkToOriginal: "Liên Kết Gốc",
    },
    search: {
      title: "Tìm Kiếm",
      searchBarPlaceholder: "Tìm kiếm thông tin",
    },
    tableOfContents: {
      title: "Bảng Nội Dung",
    },
    contentMeta: {
      readingTime: ({ minutes }) => `đọc ${minutes} phút`,
=======
      title: "Nội dung",
    },
    footer: {
      createdWith: "Được tạo bằng",
    },
    graph: {
      title: "Sơ đồ",
    },
    recentNotes: {
      title: "Ghi chú gần đây",
      seeRemainingMore: ({ remaining }) => `Xem thêm ${remaining} ghi chú →`,
    },
    transcludes: {
      transcludeOf: ({ targetSlug }) => `Trích dẫn toàn bộ từ ${targetSlug}`,
      linkToOriginal: "Xem trang gốc",
    },
    search: {
      title: "Tìm",
      searchBarPlaceholder: "Tìm kiếm thông tin",
    },
    tableOfContents: {
      title: "Mục lục",
    },
    contentMeta: {
      readingTime: ({ minutes }) => `${minutes} phút đọc`,
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
  },
  pages: {
    rss: {
<<<<<<< HEAD
      recentNotes: "Những bài gần đây",
      lastFewNotes: ({ count }) => `${count} Bài gần đây`,
    },
    error: {
      title: "Không Tìm Thấy",
      notFound: "Trang này được bảo mật hoặc không tồn tại.",
      home: "Trở về trang chủ",
    },
    folderContent: {
      folder: "Thư Mục",
      itemsUnderFolder: ({ count }) =>
        count === 1 ? "1 mục trong thư mục này." : `${count} mục trong thư mục này.`,
    },
    tagContent: {
      tag: "Thẻ",
      tagIndex: "Thẻ Mục Lục",
      itemsUnderTag: ({ count }) =>
        count === 1 ? "1 mục gắn thẻ này." : `${count} mục gắn thẻ này.`,
      showingFirst: ({ count }) => `Hiển thị trước ${count} thẻ.`,
      totalTags: ({ count }) => `Tìm thấy ${count} thẻ tổng cộng.`,
=======
      recentNotes: "Ghi chú gần đây",
      lastFewNotes: ({ count }) => `${count} Trang gần đây`,
    },
    error: {
      title: "Không tìm thấy",
      notFound: "Trang này riêng tư hoặc không tồn tại.",
      home: "Về trang chủ",
    },
    folderContent: {
      folder: "Thư mục",
      itemsUnderFolder: ({ count }) => `Có ${count} trang trong thư mục này.`,
    },
    tagContent: {
      tag: "Thẻ",
      tagIndex: "Danh sách thẻ",
      itemsUnderTag: ({ count }) => `Có ${count} trang gắn thẻ này.`,
      showingFirst: ({ count }) => `Đang hiển thị ${count} trang đầu tiên.`,
      totalTags: ({ count }) => `Có tổng cộng ${count} thẻ.`,
>>>>>>> 59b58076016c5e5f09f16ab0395fed02e2ebb72e
    },
  },
} as const satisfies Translation
