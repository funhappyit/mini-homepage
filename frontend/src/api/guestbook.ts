import apiClient from './client'

export interface GuestbookEntry {
  id: number
  nickname: string
  content: string
  createdAt: string
}

export interface GuestbookCreatePayload {
  nickname: string
  password: string
  content: string
}

export async function fetchGuestbook(): Promise<GuestbookEntry[]> {
  const { data } = await apiClient.get<GuestbookEntry[]>('/api/v1/guestbook')
  return data
}

export async function createGuestbookEntry(payload: GuestbookCreatePayload): Promise<GuestbookEntry> {
  const { data } = await apiClient.post<GuestbookEntry>('/api/v1/guestbook', payload)
  return data
}

export async function deleteGuestbookEntry(id: number, password: string): Promise<void> {
  await apiClient.delete(`/api/v1/guestbook/${id}`, { data: { password } })
}
