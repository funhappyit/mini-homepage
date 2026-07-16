export interface ProfileData {
  nickname: string
  mood: string
  statusMessage: string
  bio: string
  skills: string[]
  contacts: { label: string; value: string; href?: string }[]
}

// [임시] 실제 프로필 정보로 교체 필요
export const profile: ProfileData = {
  nickname: '[임시] 미니홈피 주인장',
  mood: '행복 🥰',
  statusMessage: '[임시] 오늘도 코딩하는 중 ✨',
  bio: '[임시] 자기소개를 여기에 채워주세요. 좋아하는 기술, 관심사, 하고 싶은 이야기를 자유롭게 적어보세요.',
  skills: ['[임시] Vue', '[임시] TypeScript', '[임시] Spring Boot'],
  contacts: [
    { label: 'Email', value: '[임시] example@email.com', href: 'mailto:example@email.com' },
    { label: 'GitHub', value: '[임시] github.com/your-id', href: 'https://github.com' },
  ],
}
